package com.mockst.mocking.module.user.dao;

import com.mockst.mocking.module.user.entity.UserEntity;
import tk.mybatis.mapper.common.Mapper;

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
public interface UserDao extends Mapper<UserEntity> {

    //Custom Generate Code Start
    List<Map<String,Object>> findByCondition(Map<String, Object> param);
    //Custom Generate Code End
}
