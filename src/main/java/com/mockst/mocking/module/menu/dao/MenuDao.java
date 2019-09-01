package com.mockst.mocking.module.menu.dao;

import com.mockst.mocking.model.menu.TreeMenu;
import com.mockst.mocking.module.menu.entity.MenuEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
//Import Package End
/**
 * 系统菜单
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-28 20:33:46
 */
public interface MenuDao extends Mapper<MenuEntity> {

    //Custom Generate Code Start
    List<TreeMenu> findAllMenus();
    List<TreeMenu> findMenusByParentId(String ParentId);
    //Custom Generate Code End
}
