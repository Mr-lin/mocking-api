package com.mockst.mocking.module.menu.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 系统菜单
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-28 20:33:46
 */
@Table(name = "tb_menu")
public class MenuEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//部门名称
    @Column(name = "name")
	private String name;
		
	//备注
    @Column(name = "parent_id")
	private String parentId;
		
	//创建人
    @Column(name = "sort")
	private Integer sort;
		
	//是否显示
    @Column(name = "is_show")
	private String isShow;
		
	//
    @Column(name = "permission")
	private String permission;
		
	//类型 1菜单 2按钮
    @Column(name = "type")
	private String type;
								
	/**
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
	}
		
	/**
	 * 设置：备注
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：备注
	 */
	public String getParentId() {
		return parentId;
	}
		
	/**
	 * 设置：创建人
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getSort() {
		return sort;
	}
		
	/**
	 * 设置：是否显示
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否显示
	 */
	public String getIsShow() {
		return isShow;
	}
		
	/**
	 * 设置：
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	/**
	 * 获取：
	 */
	public String getPermission() {
		return permission;
	}
		
	/**
	 * 设置：类型 1菜单 2按钮
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型 1菜单 2按钮
	 */
	public String getType() {
		return type;
	}
					
    @Override
    public String toString() {
        return "MenuEntity{" +
                    " id='" + id + '\'' +
                    " name='" + name + '\'' +
                    " parentId='" + parentId + '\'' +
                    " sort='" + sort + '\'' +
                    " isShow='" + isShow + '\'' +
                    " permission='" + permission + '\'' +
                    " type='" + type + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
