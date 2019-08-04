package com.mockst.mocking.module.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryModuleDao;
import com.mockst.mocking.module.repository.entity.RepositoryModuleEntity;
import com.mockst.mocking.module.repository.service.RepositoryModuleService;
//Import Package End
/**
 * repository接口工程模块
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:41
 */
@Service("repositoryModuleService")
public class RepositoryModuleServiceImpl extends BaseServiceImpl<RepositoryModuleEntity> implements RepositoryModuleService {
	@Autowired
	private RepositoryModuleDao repositoryModuleDao;
    //Custom Generate Code Start
    //Custom Generate Code End
}
