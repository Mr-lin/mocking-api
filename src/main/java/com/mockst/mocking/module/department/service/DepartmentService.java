package com.mockst.mocking.module.department.service;

import com.esnotary.framework.service.BaseService;
import com.mockst.mocking.module.department.entity.DepartmentEntity;

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
public interface DepartmentService extends BaseService<DepartmentEntity> {

    //Custom Generate Code Start
    List<Map<String,Object>> findByCondition(Map<String, Object> param);
    //Custom Generate Code End
}
