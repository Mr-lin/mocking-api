package com.mockst.mocking.module.repository.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * repository接口工程
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Table(name = "tb_repository")
public class RepositoryEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//项目名称
    @Column(name = "repository_name")
	private String repositoryName;
		
	//描述
    @Column(name = "description")
	private String description;
		
	//创建者
    @Column(name = "creator_id")
	private String creatorId;
		
	//发布版本
    @Column(name = "r_version")
	private String rVersion;
								
	/**
	 * 设置：项目名称
	 */
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getRepositoryName() {
		return repositoryName;
	}
		
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
		
	/**
	 * 设置：创建者
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * 获取：创建者
	 */
	public String getCreatorId() {
		return creatorId;
	}
		
	/**
	 * 设置：发布版本
	 */
	public void setRVersion(String rVersion) {
		this.rVersion = rVersion;
	}
	/**
	 * 获取：发布版本
	 */
	public String getRVersion() {
		return rVersion;
	}
					
    @Override
    public String toString() {
        return "RepositoryEntity{" +
                    " id='" + id + '\'' +
                    " repositoryName='" + repositoryName + '\'' +
                    " description='" + description + '\'' +
                    " creatorId='" + creatorId + '\'' +
                    " rVersion='" + rVersion + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
