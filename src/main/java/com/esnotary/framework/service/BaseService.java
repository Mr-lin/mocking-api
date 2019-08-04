package com.esnotary.framework.service;

import com.esnotary.framework.entity.BaseEntity;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author linzhiwei
 * @Description:
 * @date 2019/3/29 16:30
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 主键查询
     * @param key
     * @return
     */
    T selectByKey(Object key);

    /**
     * 全量新增
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 选择字段新增
     * @param entity
     * @return
     */
    int saveSelective(T entity);

    /**
     * 主键删除
     * @param key
     * @return
     */
    int delete(Object key);

    /**
     * 条件删除
     * @return
     */
    int deleteByExample(Example example);

    /**
     * 全量更新
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 选择字段更新
     * @param entity
     * @return
     */
    int updateSelective(T entity);

    /**
     * 条件更新
     * @param example
     * @return
     */
    int updateByExample(T entity, Example example);

    /**
     * 条件更新选择字段
     * @param entity
     * @param example
     * @return
     */
    int updateByExampleSelective(T entity, Example example);

    /**
     * 条件查询
     * @param example
     * @return
     */
    List<T> selectByExample(Example example);

    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();

    T selectOneByExample(Example example);

    int selectCountByExample(Example example);

    T selectOne(T entity);

}
