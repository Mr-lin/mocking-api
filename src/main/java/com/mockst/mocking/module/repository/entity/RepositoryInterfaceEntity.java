package com.mockst.mocking.module.repository.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * repository接口
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Table(name = "tb_repository_interface")
public class RepositoryInterfaceEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//接口名称
    @Column(name = "interface_name")
	private String interfaceName;
		
	//接口描述
    @Column(name = "description")
	private String description;
		
	//请求路径
    @Column(name = "url")
	private String url;
		
	//请求方式 GET POST
    @Column(name = "method")
	private String method;
		
	//返回状态码
    @Column(name = "status")
	private Integer status;
		
	//排序
    @Column(name = "order")
	private Integer order;
		
	//所属模块
    @Column(name = "module_id")
	private String moduleId;
		
	//创建者
    @Column(name = "creator_id")
	private String creatorId;
								
	/**
	 * 设置：接口名称
	 */
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	/**
	 * 获取：接口名称
	 */
	public String getInterfaceName() {
		return interfaceName;
	}
		
	/**
	 * 设置：接口描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：接口描述
	 */
	public String getDescription() {
		return description;
	}
		
	/**
	 * 设置：请求路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：请求路径
	 */
	public String getUrl() {
		return url;
	}
		
	/**
	 * 设置：请求方式 GET POST
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：请求方式 GET POST
	 */
	public String getMethod() {
		return method;
	}
		
	/**
	 * 设置：返回状态码
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：返回状态码
	 */
	public Integer getStatus() {
		return status;
	}
		
	/**
	 * 设置：排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrder() {
		return order;
	}
		
	/**
	 * 设置：所属模块
	 */
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	/**
	 * 获取：所属模块
	 */
	public String getModuleId() {
		return moduleId;
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
        return "RepositoryInterfaceEntity{" +
                    " id='" + id + '\'' +
                    " interfaceName='" + interfaceName + '\'' +
                    " description='" + description + '\'' +
                    " url='" + url + '\'' +
                    " method='" + method + '\'' +
                    " status='" + status + '\'' +
                    " order='" + order + '\'' +
                    " moduleId='" + moduleId + '\'' +
                    " creatorId='" + creatorId + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
