package com.mockst.mocking.module.menu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.menu.dao.MenuRoleDao;
import com.mockst.mocking.module.menu.entity.MenuRoleEntity;
import com.mockst.mocking.module.menu.service.MenuRoleService;

import java.util.List;
//Import Package End
/**
 * 角色权限
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-28 20:33:46
 */
@Service("menuRoleService")
public class MenuRoleServiceImpl extends BaseServiceImpl<MenuRoleEntity> implements MenuRoleService {
	@Autowired
	private MenuRoleDao menuRoleDao;
    //Custom Generate Code Start
	@Override
	public List<String> findPermissionByRoleId(String roleId){
		return menuRoleDao.findPermissionByRoleId(roleId);
	}
    //Custom Generate Code End
}
