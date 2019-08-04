package com.mockst.mocking.module.user.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 系统用户
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:48:21
 */
@Table(name = "tb_user")
public class UserEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//登录名
    @Column(name = "username")
	private String username;
		
	//真实姓名
    @Column(name = "real_name")
	private String realName;
		
	//密码
    @Column(name = "password")
	private String password;
		
	//头像
    @Column(name = "photo")
	private String photo;
		
	//所属部门
    @Column(name = "department_id")
	private String departmentId;
		
	//所属角色
    @Column(name = "role_id")
	private String roleId;
		
	//邮箱
    @Column(name = "email")
	private String email;
								
	/**
	 * 设置：登录名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：登录名
	 */
	public String getUsername() {
		return username;
	}
		
	/**
	 * 设置：真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
	}
		
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
		
	/**
	 * 设置：头像
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * 获取：头像
	 */
	public String getPhoto() {
		return photo;
	}
		
	/**
	 * 设置：所属部门
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * 获取：所属部门
	 */
	public String getDepartmentId() {
		return departmentId;
	}
		
	/**
	 * 设置：所属角色
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：所属角色
	 */
	public String getRoleId() {
		return roleId;
	}
		
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
					
    @Override
    public String toString() {
        return "UserEntity{" +
                    " id='" + id + '\'' +
                    " username='" + username + '\'' +
                    " realName='" + realName + '\'' +
                    " password='" + password + '\'' +
                    " photo='" + photo + '\'' +
                    " departmentId='" + departmentId + '\'' +
                    " roleId='" + roleId + '\'' +
                    " email='" + email + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
