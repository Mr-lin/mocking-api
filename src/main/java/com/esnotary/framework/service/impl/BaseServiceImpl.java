package com.esnotary.framework.service.impl;

import com.esnotary.framework.entity.BaseEntity;
import com.esnotary.framework.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author linzhiwei
 * @Description:
 * @date 2019/3/29 16:38
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entity) {
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int saveSelective(T entity) {
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return mapper.insertSelective(entity);
    }

    @Override
    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int deleteByExample(Example example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int update(T entity) {
        entity.setUpdateTime(new Date());
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateSelective(T entity) {
        entity.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateByExample(T entity,Example example) {
        entity.setUpdateTime(new Date());
        return mapper.updateByExample(entity,example);
    }

    @Override
    public int updateByExampleSelective(T entity, Example example) {
        entity.setUpdateTime(new Date());
        return mapper.updateByExampleSelective(entity,example);
    }

    @Override
    public List<T> selectByExample(Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectOneByExample(Example example) {
        return mapper.selectOneByExample(example);
    }

    @Override
    public int selectCountByExample(Example example) {
        return mapper.selectCountByExample(example);
    }

    @Override
    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

}
