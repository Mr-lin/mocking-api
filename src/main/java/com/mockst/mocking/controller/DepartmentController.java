package com.mockst.mocking.controller;

import com.esnotary.framework.entity.PageInfo;
import com.esnotary.framework.result.APIResult;
import com.esnotary.framework.result.APIResultUtil;
import com.github.pagehelper.PageHelper;
import com.mockst.mocking.config.WebConfigurer;
import com.mockst.mocking.module.department.entity.DepartmentEntity;
import com.mockst.mocking.module.department.service.DepartmentService;
import com.mockst.mocking.module.role.entity.RoleEntity;
import com.mockst.mocking.module.role.service.RoleService;
import com.mockst.mocking.module.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/3 23:27
 * @Description:
 */
@RestController
@RequestMapping(WebConfigurer.API_BASE_PATH+"/department")
public class DepartmentController extends BaseAPIController{

    @Autowired
    private DepartmentService departmentService;

    /**
     * 列表
     * @return
     */
    @RequestMapping("list")
    public APIResult list(@RequestParam Map<String,Object> param,
                          @RequestParam(defaultValue = "1")Integer pageNo,
                          @RequestParam(defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String,Object>> list = departmentService.findByCondition(param);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
        return APIResultUtil.returnSuccessResult(pageInfo);
    }

    /**
     * 新增
     */
    @RequestMapping("addDepartment")
    public APIResult addDepartment(HttpServletRequest request,@RequestParam String departmentName, @RequestParam String remark){
        UserEntity userEntity = getCurrentUser(request);
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(departmentName);
        departmentEntity.setRemark(remark);
        departmentEntity.setCreatorId(userEntity.getId());
        departmentService.save(departmentEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 编辑
     * @return
     */
    @RequestMapping("updateDepartment")
    public APIResult updateDepartment(@RequestParam String id,@RequestParam String departmentName,@RequestParam String remark){
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(id);
        departmentEntity.setDepartmentName(departmentName);
        departmentEntity.setRemark(remark);
        departmentService.updateSelective(departmentEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deleteDepartment")
    public APIResult deleteDepartment(@RequestParam String id){
        departmentService.delete(id);
        return APIResultUtil.returnSuccessResult(null);
    }
}
