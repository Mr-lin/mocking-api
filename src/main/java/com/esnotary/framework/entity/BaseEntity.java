package com.esnotary.framework.entity;

import com.esnotary.framework.util.GenUtil;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author linzhiwei
 * @Description:
 * @date 2019/3/29 11:31
 */
public abstract class BaseEntity implements Serializable{

    @Id
    @KeySql(genId = GenUtil.class)
    @Column(name = "id")
    protected String id;

    @Column(name = "create_time")
    protected Date createTime;
    @Column(name = "update_time")
    protected Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
