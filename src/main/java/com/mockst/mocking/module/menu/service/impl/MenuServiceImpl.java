package com.mockst.mocking.module.menu.service.impl;

import com.mockst.mocking.model.menu.TreeMenu;
import com.mockst.mocking.module.menu.service.MenuRoleService;
import com.mockst.mocking.module.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.menu.dao.MenuDao;
import com.mockst.mocking.module.menu.entity.MenuEntity;
import com.mockst.mocking.module.menu.service.MenuService;

import java.util.List;
import java.util.stream.Collectors;
//Import Package End
/**
 * 系统菜单
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-28 20:33:46
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<MenuEntity> implements MenuService {
	@Autowired
	private MenuDao menuDao;

	//Custom Generate Code Start

	@Autowired
	private MenuRoleService menuRoleService;

	@Override
	public List<TreeMenu> findAllMenus() {
		return menuDao.findAllMenus();
	}

	@Override
	public List<String> findUser(UserEntity userEntity) {
		//超级管理员查询所有
		if ("1".equals(userEntity.getId())){
			return selectAll().stream().filter(s->"1".equals(s.getIsShow()))
					.map(s->s.getPermission())
					.collect(Collectors.toList());
		}
		return menuRoleService.findPermissionByRoleId(userEntity.getRoleId());
	}
	//Custom Generate Code End
}
