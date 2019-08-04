package com.mockst.mocking.module.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryInterfaceDao;
import com.mockst.mocking.module.repository.entity.RepositoryInterfaceEntity;
import com.mockst.mocking.module.repository.service.RepositoryInterfaceService;
//Import Package End
/**
 * repository接口
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Service("repositoryInterfaceService")
public class RepositoryInterfaceServiceImpl extends BaseServiceImpl<RepositoryInterfaceEntity> implements RepositoryInterfaceService {
	@Autowired
	private RepositoryInterfaceDao repositoryInterfaceDao;
    //Custom Generate Code Start
    //Custom Generate Code End
}
