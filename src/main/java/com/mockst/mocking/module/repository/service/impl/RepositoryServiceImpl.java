package com.mockst.mocking.module.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryDao;
import com.mockst.mocking.module.repository.entity.RepositoryEntity;
import com.mockst.mocking.module.repository.service.RepositoryService;
//Import Package End
/**
 * repository接口工程
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Service("repositoryService")
public class RepositoryServiceImpl extends BaseServiceImpl<RepositoryEntity> implements RepositoryService {
	@Autowired
	private RepositoryDao repositoryDao;
    //Custom Generate Code Start
    //Custom Generate Code End
}
