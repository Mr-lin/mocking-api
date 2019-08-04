package com.mockst.mocking.module.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.role.dao.RoleDao;
import com.mockst.mocking.module.role.entity.RoleEntity;
import com.mockst.mocking.module.role.service.RoleService;

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
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<RoleEntity> implements RoleService {
	@Autowired
	private RoleDao roleDao;

	//Custom Generate Code Start
	@Override
	public List<Map<String, Object>> findByCondition(Map<String, Object> condition) {
		return roleDao.findByCondition(condition);
	}
    //Custom Generate Code End
}
