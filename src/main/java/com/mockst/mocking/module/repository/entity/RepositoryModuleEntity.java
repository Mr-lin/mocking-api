package com.mockst.mocking.module.repository.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * repository接口工程模块
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:41
 */
@Table(name = "tb_repository_module")
public class RepositoryModuleEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//模块名称
    @Column(name = "module_name")
	private String moduleName;
		
	//模块描述
    @Column(name = "description")
	private String description;
		
	//排序
    @Column(name = "sort")
	private Integer sort;
		
	//所属工程
    @Column(name = "repository_id")
	private String repositoryId;
		
	//创建者
    @Column(name = "creator_id")
	private String creatorId;
								
	/**
	 * 设置：模块名称
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	/**
	 * 获取：模块名称
	 */
	public String getModuleName() {
		return moduleName;
	}
		
	/**
	 * 设置：模块描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：模块描述
	 */
	public String getDescription() {
		return description;
	}
		
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
		
	/**
	 * 设置：所属工程
	 */
	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}
	/**
	 * 获取：所属工程
	 */
	public String getRepositoryId() {
		return repositoryId;
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
					
    @Override
    public String toString() {
        return "RepositoryModuleEntity{" +
                    " id='" + id + '\'' +
                    " moduleName='" + moduleName + '\'' +
                    " description='" + description + '\'' +
                    " sort='" + sort + '\'' +
                    " repositoryId='" + repositoryId + '\'' +
                    " creatorId='" + creatorId + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
