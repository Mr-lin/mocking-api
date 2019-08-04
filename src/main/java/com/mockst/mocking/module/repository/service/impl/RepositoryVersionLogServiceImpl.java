package com.mockst.mocking.module.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryVersionLogDao;
import com.mockst.mocking.module.repository.entity.RepositoryVersionLogEntity;
import com.mockst.mocking.module.repository.service.RepositoryVersionLogService;
//Import Package End
/**
 * 仓库修改操作日志
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:41
 */
@Service("repositoryVersionLogService")
public class RepositoryVersionLogServiceImpl extends BaseServiceImpl<RepositoryVersionLogEntity> implements RepositoryVersionLogService {
	@Autowired
	private RepositoryVersionLogDao repositoryVersionLogDao;
    //Custom Generate Code Start
    //Custom Generate Code End
}
