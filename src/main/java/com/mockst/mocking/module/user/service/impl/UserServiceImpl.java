package com.mockst.mocking.module.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.user.dao.UserDao;
import com.mockst.mocking.module.user.entity.UserEntity;
import com.mockst.mocking.module.user.service.UserService;

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
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements UserService {
	@Autowired
	private UserDao userDao;

	//Custom Generate Code Start
	@Override
	public List<Map<String, Object>> findByCondition(Map<String, Object> param) {
		return userDao.findByCondition(param);
	}
    //Custom Generate Code End
}
