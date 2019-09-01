package com.mockst.mocking.module.menu.service;

import com.esnotary.framework.service.BaseService;
import com.mockst.mocking.module.menu.entity.MenuRoleEntity;

import java.util.List;
//Import Package End
/**
 * 角色权限
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-28 20:33:46
 */
public interface MenuRoleService extends BaseService<MenuRoleEntity> {
    //Custom Generate Code Start
    List<String> findPermissionByRoleId(String roleId);
    //Custom Generate Code End
}
