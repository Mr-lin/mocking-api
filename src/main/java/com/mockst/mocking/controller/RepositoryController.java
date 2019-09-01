package com.mockst.mocking.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.esnotary.framework.entity.PageInfo;
import com.esnotary.framework.result.APIResult;
import com.esnotary.framework.result.APIResultUtil;
import com.esnotary.framework.util.VelocityUtil;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;
import com.github.pagehelper.PageHelper;
import com.mockst.mocking.config.WebConfigurer;
import com.mockst.mocking.constant.Constant;
import com.mockst.mocking.model.repository.*;
import com.mockst.mocking.module.department.entity.DepartmentEntity;
import com.mockst.mocking.module.repository.entity.*;
import com.mockst.mocking.module.repository.service.*;
import com.mockst.mocking.module.user.entity.UserEntity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/11 21:43
 * @Description:
 */
@RestController
@RequestMapping(WebConfigurer.API_BASE_PATH+"/repository")
public class RepositoryController extends BaseAPIController {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RepositoryMemberService repositoryMemberService;
    @Autowired
    private RepositoryModuleService repositoryModuleService;
    @Autowired
    private RepositoryInterfaceService repositoryInterfaceService;
    @Autowired
    private RepositoryInterfacePropertyService repositoryInterfacePropertyService;
    /**
     * 列表
     * @return
     */
    @RequestMapping("list")
    public APIResult list(@RequestParam Map<String,Object> param,
                          @RequestParam(defaultValue = "1")Integer pageNo,
                          @RequestParam(defaultValue = "10")Integer pageSize,
                            HttpServletRequest request){
        UserEntity userEntity = getCurrentUser(request);
        PageHelper.startPage(pageNo,pageSize);
        if (!Constant.ADMIN_ID.equals(userEntity.getId())){
            param.put("memberId",userEntity.getId());
        }
        List<Map<String,Object>> list = repositoryService.findByCondition(param);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
        return APIResultUtil.returnSuccessResult(pageInfo);
    }

    /**
     * 新增
     */
    @RequestMapping("addRepository")
    public APIResult addRepository(HttpServletRequest request,
                                   @RequestParam String repositoryName,
                                   @RequestParam String description,
                                    String[] userIds){
        UserEntity userEntity = getCurrentUser(request);
        RepositoryEntity repositoryEntity = new RepositoryEntity();
        repositoryEntity.setRepositoryName(repositoryName);
        repositoryEntity.setDescription(description);
        repositoryEntity.setCreatorId(userEntity.getId());
        repositoryService.save(repositoryEntity);
        if (userIds!=null){
            for (String userId:userIds){
                RepositoryMemberEntity repositoryMemberEntity  = new RepositoryMemberEntity();
                repositoryMemberEntity.setRepositoryId(repositoryEntity.getId());
                repositoryMemberEntity.setUserId(userId);
                repositoryMemberService.save(repositoryMemberEntity);
            }
        }
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 编辑
     * @return
     */
    @RequestMapping("updateRepository")
    public APIResult updateRepository(@RequestParam String id,
                                      @RequestParam String repositoryName,
                                      @RequestParam String description,
                                      String[] userIds){
        RepositoryEntity repositoryEntity = new RepositoryEntity();
        repositoryEntity.setId(id);
        repositoryEntity.setRepositoryName(repositoryName);
        repositoryEntity.setDescription(description);
        repositoryService.updateSelective(repositoryEntity);
        //删除旧的
        Example query = new Example(RepositoryMemberEntity.class);
        query.createCriteria().andEqualTo("repositoryId",id);
        repositoryMemberService.deleteByExample(query);
        if (userIds!=null){
            for (String userId:userIds){
                RepositoryMemberEntity repositoryMemberEntity  = new RepositoryMemberEntity();
                repositoryMemberEntity.setRepositoryId(repositoryEntity.getId());
                repositoryMemberEntity.setUserId(userId);
                repositoryMemberService.save(repositoryMemberEntity);
            }
        }
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deleteRepository")
    public APIResult deleteRepository(@RequestParam String id){
        repositoryService.delete(id);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 项目信息
     */
    @RequestMapping("repositoryInfo")
    public APIResult repositoryInfo(@RequestParam String repositoryId){
        RepositoryInfoDTO repositoryInfo = repositoryService.findById(repositoryId);
        return APIResultUtil.returnSuccessResult(repositoryInfo);
    }

    /**
     * 导出接口文档
     * @param repositoryId
     */
    @RequestMapping("outRepositoryInfo")
    public void outRepositoryInfo(@RequestParam String repositoryId, HttpServletResponse response){
        String json ="{ \"name\": \"zhangsan\", \"age\": 18 ,\"code\":\"100001\"}";
        if(StringUtils.isBlank(json)){
            return ;
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(json);
        }catch (Exception e){
            return ;
        }
        RepositoryEntity repositoryEntity = repositoryService.selectByKey(repositoryId);
        String responseExample = JSONObject.toJSONString(jsonObject,true);
        RepositoryModuleEntity query = new RepositoryModuleEntity();
        query.setRepositoryId(repositoryId);
        List<RepositoryModuleEntity> list = repositoryModuleService.select(query);
        JSONObject data = new JSONObject();
        JSONArray modules = new JSONArray();
        list.forEach(m->{
            JSONObject module = new JSONObject();
            module.put("moduleName",m.getModuleName());
            JSONArray interfaces = new JSONArray();
            RepositoryInterfaceEntity repositoryInterface = new RepositoryInterfaceEntity();
            repositoryInterface.setModuleId(m.getId());
            List<RepositoryInterfaceEntity> interfaceList = repositoryInterfaceService.select(repositoryInterface);
            interfaceList.forEach(i->{
                OutInterfaceDTO it = repositoryInterfacePropertyService.findByInterfaceId(i.getId());
                interfaces.add(it);
            });
            module.put("interfaces",interfaces);
            modules.add(module);
        });
        data.put("modules",modules);
        String template = "templates/api.vm";
        try (OutputStream out = response.getOutputStream()){
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(repositoryEntity.getRepositoryName()+".pdf", "utf-8"));
            String html = VelocityUtil.outFile(template,data);
            Pdf pdf = new Pdf();
            pdf.addPageFromString(html);
            pdf.addParam(new Param("--page-size","A4"));
            pdf.addParam(new Param("--margin-left","20"));
            pdf.addParam(new Param("--margin-right","20"));
            pdf.addParam(new Param("--margin-top","20"));
            pdf.addParam(new Param("--margin-bottom", "20"));
            IOUtils.write(pdf.getPDF(),out);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 模块信息
     */
    @RequestMapping("moduleInfo")
    public APIResult moduleInfo(@RequestParam String moduleId){
        RepositoryInterfaceEntity query = new RepositoryInterfaceEntity();
        query.setModuleId(moduleId);
        List<RepositoryInterfaceEntity> list = repositoryInterfaceService.select(query);
        JSONObject data = new JSONObject();
        data.put("interfaces",list);
        return APIResultUtil.returnSuccessResult(data);
    }

    /**
     * 添加模块
     * @return
     */
    @RequestMapping("addModule")
    public APIResult addModule(HttpServletRequest request,@RequestParam String repositoryId,@RequestParam String moduleName,@RequestParam String description){
        UserEntity userEntity = getCurrentUser(request);
        RepositoryModuleEntity moduleEntity = new RepositoryModuleEntity();
        moduleEntity.setModuleName(moduleName);
        moduleEntity.setDescription(description);
        moduleEntity.setCreatorId(userEntity.getId());
        moduleEntity.setRepositoryId(repositoryId);
        repositoryModuleService.save(moduleEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 更新模块
     */
    @RequestMapping("updateModule")
    public APIResult updateModule(@RequestParam String moduleId,@RequestParam String moduleName,@RequestParam String description){
        RepositoryModuleEntity moduleEntity = new RepositoryModuleEntity();
        moduleEntity.setId(moduleId);
        moduleEntity.setModuleName(moduleName);
        moduleEntity.setDescription(description);
        repositoryModuleService.updateSelective(moduleEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 删除模块
     */
    @RequestMapping("deleteModule")
    public APIResult deleteModule(@RequestParam String moduleId){
        repositoryModuleService.delete(moduleId);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 添加接口
     * @return
     */
    @RequestMapping("addInterface")
    public APIResult addInterface(HttpServletRequest request, RepositoryInterfaceDTO repositoryInterfaceDTO){
        UserEntity userEntity = getCurrentUser(request);
        RepositoryInterfaceEntity repositoryInterfaceEntity = new RepositoryInterfaceEntity();
        BeanUtils.copyProperties(repositoryInterfaceDTO,repositoryInterfaceEntity);
        repositoryInterfaceEntity.setCreatorId(userEntity.getId());
        repositoryInterfaceService.save(repositoryInterfaceEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 编辑接口
     * @return
     */
    @RequestMapping("updateInterface")
    public APIResult updateInterface(RepositoryInterfaceDTO repositoryInterfaceDTO){
        RepositoryInterfaceEntity repositoryInterfaceEntity = new RepositoryInterfaceEntity();
        BeanUtils.copyProperties(repositoryInterfaceDTO,repositoryInterfaceEntity);
        repositoryInterfaceService.updateSelective(repositoryInterfaceEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 删除接口
     */
    @RequestMapping("deleteInterface")
    public APIResult deleteInterface(@RequestParam String interfaceId){
        repositoryInterfaceService.delete(interfaceId);
        return APIResultUtil.returnSuccessResult(null);
    }

    @RequestMapping("propertyInfo")
    public APIResult propertyInfo(@RequestParam String interfaceId){
        List<InterfacePropertyDTO> list = repositoryInterfacePropertyService.findProperiesByInterfaceId(interfaceId);
        JSONObject data = new JSONObject();
        RepositoryInterfaceEntity repositoryInterfaceEntity = repositoryInterfaceService.selectByKey(interfaceId);
        data.put("url",repositoryInterfaceEntity.getUrl());
        data.put("method",repositoryInterfaceEntity.getMethod());
        data.put("requestProperties",
                list.stream().filter(s->"request".equals(s.getScope()))
                        .collect(Collectors.toList()));
        data.put("responseProperties",
                list.stream().filter(s->"response".equals(s.getScope()))
                        .collect(Collectors.toList()));
        return APIResultUtil.returnSuccessResult(data);
    }


    /**
     * 添加临时属性
     * @param interfacePropertyDTO
     * @return
     */
    @RequestMapping("addProperty")
    public APIResult addProperty(InterfacePropertyDTO interfacePropertyDTO){
        RepositoryInterfacePropertyEntity propertyEntity = new RepositoryInterfacePropertyEntity();
        BeanUtils.copyProperties(interfacePropertyDTO,propertyEntity);
        propertyEntity.setIsDelete(Constant.IS_DELETE);
        propertyEntity.setDeleteTime(new Date());
        repositoryInterfacePropertyService.save(propertyEntity);
        return APIResultUtil.returnSuccessResult(propertyEntity);
    }

    /**
     * 更新属性
     * @param interfacePropertyJson
     * @return
     */
    @RequestMapping("updateProperty")
    public APIResult updateProperty(@RequestParam String interfacePropertyJson){
        InterfacePropertyForm form = JSONObject.parseObject(interfacePropertyJson,InterfacePropertyForm.class);
        List<RepositoryInterfacePropertyEntity> properties = new ArrayList<>();
        for (int i=0;i<form.getRequestProperties().size();i++){
            InterfacePropertyDTO p = form.getRequestProperties().get(i);
            RepositoryInterfacePropertyEntity propertyEntity = new RepositoryInterfacePropertyEntity();
            BeanUtils.copyProperties(p,propertyEntity);
            propertyEntity.setScope("request");
            propertyEntity.setSort(i+1);
            propertyEntity.setInterfaceId(form.getInterfaceId());
            propertyEntity.setIsDelete(Constant.IS_NOT_DELETE);
            propertyEntity.setDeleteTime(null);
            propertyEntity.setCreateTime(new Date());
            properties.add(propertyEntity);
        }
        for (int i=0;i<form.getResponseProperties().size();i++){
            InterfacePropertyDTO p = form.getResponseProperties().get(i);
            RepositoryInterfacePropertyEntity propertyEntity = new RepositoryInterfacePropertyEntity();
            BeanUtils.copyProperties(p,propertyEntity);
            propertyEntity.setScope("response");
            propertyEntity.setSort(i+1);
            propertyEntity.setInterfaceId(form.getInterfaceId());
            propertyEntity.setIsDelete(Constant.IS_NOT_DELETE);
            propertyEntity.setDeleteTime(null);
            propertyEntity.setCreateTime(new Date());
            properties.add(propertyEntity);
        }
        repositoryInterfacePropertyService.updateProperty(form.getInterfaceId(),properties);
        return APIResultUtil.returnSuccessResult(null);
    }

}
