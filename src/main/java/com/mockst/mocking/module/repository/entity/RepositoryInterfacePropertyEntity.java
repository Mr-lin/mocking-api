package com.mockst.mocking.module.repository.entity;

import java.io.Serializable;
import java.util.Date;
import com.esnotary.framework.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * repository接口参数
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Table(name = "tb_repository_interface_property")
public class RepositoryInterfacePropertyEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
			
	//参数名称
    @Column(name = "name")
	private String name;
		
	//类型String Number Boolean Object Array Function RegExp
    @Column(name = "type")
	private String type;
		
	//参数类型 request请求 response响应
    @Column(name = "scope")
	private String scope;
		
	//规则
    @Column(name = "rule")
	private String rule;
		
	//值
    @Column(name = "value")
	private String value;
		
	//是否必填
    @Column(name = "required")
	private Integer required;
		
	//参数描述
    @Column(name = "description")
	private String description;
		
	//排序
    @Column(name = "order")
	private Integer order;
		
	//上级参数
    @Column(name = "parent_id")
	private String parentId;
		
	//所属接口
    @Column(name = "interface_id")
	private String interfaceId;
		
	//创建者
    @Column(name = "creator_id")
	private String creatorId;
								
	/**
	 * 设置：参数名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：参数名称
	 */
	public String getName() {
		return name;
	}
		
	/**
	 * 设置：类型String Number Boolean Object Array Function RegExp
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型String Number Boolean Object Array Function RegExp
	 */
	public String getType() {
		return type;
	}
		
	/**
	 * 设置：参数类型 request请求 response响应
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * 获取：参数类型 request请求 response响应
	 */
	public String getScope() {
		return scope;
	}
		
	/**
	 * 设置：规则
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}
	/**
	 * 获取：规则
	 */
	public String getRule() {
		return rule;
	}
		
	/**
	 * 设置：值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：值
	 */
	public String getValue() {
		return value;
	}
		
	/**
	 * 设置：是否必填
	 */
	public void setRequired(Integer required) {
		this.required = required;
	}
	/**
	 * 获取：是否必填
	 */
	public Integer getRequired() {
		return required;
	}
		
	/**
	 * 设置：参数描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：参数描述
	 */
	public String getDescription() {
		return description;
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
	 * 设置：上级参数
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级参数
	 */
	public String getParentId() {
		return parentId;
	}
		
	/**
	 * 设置：所属接口
	 */
	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}
	/**
	 * 获取：所属接口
	 */
	public String getInterfaceId() {
		return interfaceId;
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
        return "RepositoryInterfacePropertyEntity{" +
                    " id='" + id + '\'' +
                    " name='" + name + '\'' +
                    " type='" + type + '\'' +
                    " scope='" + scope + '\'' +
                    " rule='" + rule + '\'' +
                    " value='" + value + '\'' +
                    " required='" + required + '\'' +
                    " description='" + description + '\'' +
                    " order='" + order + '\'' +
                    " parentId='" + parentId + '\'' +
                    " interfaceId='" + interfaceId + '\'' +
                    " creatorId='" + creatorId + '\'' +
                    " createTime='" + createTime + '\'' +
                    " updateTime='" + updateTime + '\'' +
                    '}';
    }

}
