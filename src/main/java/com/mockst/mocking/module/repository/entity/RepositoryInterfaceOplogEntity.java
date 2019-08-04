package com.mockst.mocking.module.repository.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 接口修改操作日志
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Table(name = "tb_repository_interface_oplog")
public class RepositoryInterfaceOplogEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//目标接口
    @Column(name = "interface_id")
	private String interfaceId;
		
	//操作用户
    @Column(name = "op_user_id")
	private String opUserId;
		
	//操作类型 insert新增 update修改 delete删除
    @Column(name = "op_type")
	private String opType;
								
	/**
	 * 设置：目标接口
	 */
	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}
	/**
	 * 获取：目标接口
	 */
	public String getInterfaceId() {
		return interfaceId;
	}
		
	/**
	 * 设置：操作用户
	 */
	public void setOpUserId(String opUserId) {
		this.opUserId = opUserId;
	}
	/**
	 * 获取：操作用户
	 */
	public String getOpUserId() {
		return opUserId;
	}
		
	/**
	 * 设置：操作类型 insert新增 update修改 delete删除
	 */
	public void setOpType(String opType) {
		this.opType = opType;
	}
	/**
	 * 获取：操作类型 insert新增 update修改 delete删除
	 */
	public String getOpType() {
		return opType;
	}
					
    @Override
    public String toString() {
        return "RepositoryInterfaceOplogEntity{" +
                    " id='" + id + '\'' +
                    " interfaceId='" + interfaceId + '\'' +
                    " opUserId='" + opUserId + '\'' +
                    " opType='" + opType + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
