package com.mockst.mocking.controller;

import com.esnotary.framework.entity.PageInfo;
import com.esnotary.framework.result.APIResult;
import com.esnotary.framework.result.APIResultUtil;
import com.github.pagehelper.PageHelper;
import com.mockst.mocking.config.WebConfigurer;
import com.mockst.mocking.module.role.entity.RoleEntity;
import com.mockst.mocking.module.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/3 13:55
 * @Description:
 */
@RestController
@RequestMapping(WebConfigurer.API_BASE_PATH+"/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 列表
     * @return
     */
    @RequestMapping("list")
    public APIResult list(@RequestParam Map<String,Object> param,
                          @RequestParam(defaultValue = "1")Integer pageNo,
                          @RequestParam(defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String,Object>> list = roleService.findByCondition(param);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
        return APIResultUtil.returnSuccessResult(pageInfo);
    }

    /**
     * 新增
     * @param roleName
     * @param roleCode
     * @return
     */
    @RequestMapping("addRole")
    public APIResult addRole(@RequestParam String roleName,@RequestParam String roleCode,@RequestParam String remark){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleName);
        roleEntity.setRoleCode(roleCode);
        roleEntity.setRemark(remark);
        roleService.save(roleEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 编辑
     * @param id
     * @param roleName
     * @param roleCode
     * @return
     */
    @RequestMapping("updateRole")
    public APIResult updateRole(@RequestParam String id,@RequestParam String roleName,@RequestParam String roleCode,@RequestParam String remark){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(id);
        roleEntity.setRoleName(roleName);
        roleEntity.setRoleCode(roleCode);
        roleEntity.setRemark(remark);
        roleService.updateSelective(roleEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deleteRole")
    public APIResult deleteRole(@RequestParam String id){
        roleService.delete(id);
        return APIResultUtil.returnSuccessResult(null);
    }
}
