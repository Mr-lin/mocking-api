package com.mockst.mocking.module.department.dao;

import com.mockst.mocking.module.department.entity.DepartmentEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
//Import Package End
/**
 * 系统部门
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:06
 */
public interface DepartmentDao extends Mapper<DepartmentEntity> {
    //Custom Generate Code Start
    List<Map<String,Object>> findByCondition(Map<String, Object> param);
    //Custom Generate Code End
}
