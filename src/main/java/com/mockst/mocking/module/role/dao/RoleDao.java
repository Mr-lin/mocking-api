package com.mockst.mocking.module.role.dao;

import com.mockst.mocking.module.role.entity.RoleEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
//Import Package End
/**
 * 系统角色
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:55:46
 */
public interface RoleDao extends Mapper<RoleEntity> {
    //Custom Generate Code Start
    List<Map<String,Object>> findByCondition(Map<String, Object> condition);
    //Custom Generate Code End
}
