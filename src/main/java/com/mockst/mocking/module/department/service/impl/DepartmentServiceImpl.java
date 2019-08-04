package com.mockst.mocking.module.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.department.dao.DepartmentDao;
import com.mockst.mocking.module.department.entity.DepartmentEntity;
import com.mockst.mocking.module.department.service.DepartmentService;

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
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentEntity> implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	//Custom Generate Code Start
	@Override
	public List<Map<String, Object>> findByCondition(Map<String, Object> param) {
		return departmentDao.findByCondition(param);
	}
    //Custom Generate Code End
}
