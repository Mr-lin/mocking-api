package com.mockst.mocking.module.repository.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * repository接口工程成员
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Table(name = "tb_repository_member")
public class RepositoryMemberEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//相关用户
    @Column(name = "user_id")
	private String userId;
		
	//相关工程
    @Column(name = "repository_id")
	private String repositoryId;
								
	/**
	 * 设置：相关用户
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：相关用户
	 */
	public String getUserId() {
		return userId;
	}
		
	/**
	 * 设置：相关工程
	 */
	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}
	/**
	 * 获取：相关工程
	 */
	public String getRepositoryId() {
		return repositoryId;
	}
					
    @Override
    public String toString() {
        return "RepositoryMemberEntity{" +
                    " id='" + id + '\'' +
                    " userId='" + userId + '\'' +
                    " repositoryId='" + repositoryId + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
