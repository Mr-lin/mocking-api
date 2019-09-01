package com.mockst.mocking.module.menu.service;

import com.esnotary.framework.service.BaseService;
import com.mockst.mocking.model.menu.TreeMenu;
import com.mockst.mocking.module.menu.entity.MenuEntity;
import com.mockst.mocking.module.user.entity.UserEntity;

import java.util.List;
//Import Package End
/**
 * 系统菜单
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-28 20:33:46
 */
public interface MenuService extends BaseService<MenuEntity> {
    //Custom Generate Code Start
    List<TreeMenu> findAllMenus();

    List<String> findUser(UserEntity userEntity);
    //Custom Generate Code End
}
