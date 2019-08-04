package com.mockst.mocking.module.department.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 系统部门
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:06
 */
@Table(name = "tb_department")
public class DepartmentEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//部门名称
    @Column(name = "department_name")
	private String departmentName;

	//创建人
	@Column(name = "creator_id")
	private String creatorId;
		
	//备注
    @Column(name = "remark")
	private String remark;
								
	/**
	 * 设置：部门名称
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getDepartmentName() {
		return departmentName;
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

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	@Override
    public String toString() {
        return "DepartmentEntity{" +
                    " id='" + id + '\'' +
                    " departmentName='" + departmentName + '\'' +
                    " remark='" + remark + '\'' +
					"creatorId='"+ creatorId +  '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
