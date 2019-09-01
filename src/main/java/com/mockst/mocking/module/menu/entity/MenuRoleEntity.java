package com.mockst.mocking.module.menu.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 角色权限
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-28 20:33:46
 */
@Table(name = "tb_menu_role")
public class MenuRoleEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//相关用户
    @Column(name = "role_id")
	private String roleId;
		
	//相关工程
    @Column(name = "menu_id")
	private String menuId;
								
	/**
	 * 设置：相关用户
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：相关用户
	 */
	public String getRoleId() {
		return roleId;
	}
		
	/**
	 * 设置：相关工程
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：相关工程
	 */
	public String getMenuId() {
		return menuId;
	}
					
    @Override
    public String toString() {
        return "MenuRoleEntity{" +
                    " id='" + id + '\'' +
                    " roleId='" + roleId + '\'' +
                    " menuId='" + menuId + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
