package com.mockst.mocking.module.user.service;

import com.esnotary.framework.service.BaseService;
import com.mockst.mocking.module.user.entity.UserEntity;

import java.util.List;
import java.util.Map;
//Import Package End
/**
 * 系统用户
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:48:21
 */
public interface UserService extends BaseService<UserEntity> {

    //Custom Generate Code Start
    List<Map<String,Object>> findByCondition(Map<String, Object> param);
    //Custom Generate Code End
}
