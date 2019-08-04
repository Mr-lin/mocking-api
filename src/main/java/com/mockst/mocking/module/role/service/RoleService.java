package com.mockst.mocking.module.role.service;

import com.esnotary.framework.service.BaseService;
import com.mockst.mocking.module.role.entity.RoleEntity;

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
public interface RoleService extends BaseService<RoleEntity> {
    //Custom Genterate Code Start
    List<Map<String,Object>> findByCondition(Map<String,Object> condition);
    //Custom Generate Code End
}
