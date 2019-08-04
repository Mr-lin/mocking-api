package com.mockst.mocking.module.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryInterfaceOplogDao;
import com.mockst.mocking.module.repository.entity.RepositoryInterfaceOplogEntity;
import com.mockst.mocking.module.repository.service.RepositoryInterfaceOplogService;
//Import Package End
/**
 * 接口修改操作日志
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Service("repositoryInterfaceOplogService")
public class RepositoryInterfaceOplogServiceImpl extends BaseServiceImpl<RepositoryInterfaceOplogEntity> implements RepositoryInterfaceOplogService {
	@Autowired
	private RepositoryInterfaceOplogDao repositoryInterfaceOplogDao;
    //Custom Generate Code Start
    //Custom Generate Code End
}
