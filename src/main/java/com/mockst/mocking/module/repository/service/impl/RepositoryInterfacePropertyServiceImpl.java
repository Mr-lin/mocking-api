package com.mockst.mocking.module.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryInterfacePropertyDao;
import com.mockst.mocking.module.repository.entity.RepositoryInterfacePropertyEntity;
import com.mockst.mocking.module.repository.service.RepositoryInterfacePropertyService;
//Import Package End
/**
 * repository接口参数
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Service("repositoryInterfacePropertyService")
public class RepositoryInterfacePropertyServiceImpl extends BaseServiceImpl<RepositoryInterfacePropertyEntity> implements RepositoryInterfacePropertyService {
	@Autowired
	private RepositoryInterfacePropertyDao repositoryInterfacePropertyDao;
    //Custom Generate Code Start
    //Custom Generate Code End
}
