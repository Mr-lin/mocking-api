package com.mockst.mocking.module.repository.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 仓库修改操作日志
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:41
 */
@Table(name = "tb_repository_version_log")
public class RepositoryVersionLogEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//目标仓库
    @Column(name = "repository_id")
	private String repositoryId;
		
	//操作用户
    @Column(name = "op_user_id")
	private String opUserId;
		
	//操作类型 insert新增 update修改 delete删除
    @Column(name = "op_type")
	private String opType;
		
	//操作用户姓名
    @Column(name = "op_user_name")
	private String opUserName;
		
	//修改内容
    @Column(name = "op_content")
	private String opContent;
								
	/**
	 * 设置：目标仓库
	 */
	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}
	/**
	 * 获取：目标仓库
	 */
	public String getRepositoryId() {
		return repositoryId;
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
		
	/**
	 * 设置：操作用户姓名
	 */
	public void setOpUserName(String opUserName) {
		this.opUserName = opUserName;
	}
	/**
	 * 获取：操作用户姓名
	 */
	public String getOpUserName() {
		return opUserName;
	}
		
	/**
	 * 设置：修改内容
	 */
	public void setOpContent(String opContent) {
		this.opContent = opContent;
	}
	/**
	 * 获取：修改内容
	 */
	public String getOpContent() {
		return opContent;
	}
					
    @Override
    public String toString() {
        return "RepositoryVersionLogEntity{" +
                    " id='" + id + '\'' +
                    " repositoryId='" + repositoryId + '\'' +
                    " opUserId='" + opUserId + '\'' +
                    " opType='" + opType + '\'' +
                    " opUserName='" + opUserName + '\'' +
                    " opContent='" + opContent + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
