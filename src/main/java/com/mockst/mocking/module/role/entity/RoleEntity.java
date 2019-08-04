package com.mockst.mocking.module.role.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 系统角色
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:55:46
 */
@Table(name = "tb_role")
public class RoleEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//角色名
    @Column(name = "role_name")
	private String roleName;
		
	//角色编码
    @Column(name = "role_code")
	private String roleCode;
		
	//创建人
    @Column(name = "creator_id")
	private String creatorId;
		
	//备注
    @Column(name = "remark")
	private String remark;
								
	/**
	 * 设置：角色名
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 获取：角色名
	 */
	public String getRoleName() {
		return roleName;
	}
		
	/**
	 * 设置：角色编码
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	/**
	 * 获取：角色编码
	 */
	public String getRoleCode() {
		return roleCode;
	}
		
	/**
	 * 设置：创建人
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatorId() {
		return creatorId;
	}
		
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
					
    @Override
    public String toString() {
        return "RoleEntity{" +
                    " id='" + id + '\'' +
                    " roleName='" + roleName + '\'' +
                    " roleCode='" + roleCode + '\'' +
                    " creatorId='" + creatorId + '\'' +
                    " remark='" + remark + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
