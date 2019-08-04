package com.mockst.mocking.module.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryMemberDao;
import com.mockst.mocking.module.repository.entity.RepositoryMemberEntity;
import com.mockst.mocking.module.repository.service.RepositoryMemberService;
//Import Package End
/**
 * repository接口工程成员
 *
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
@Service("repositoryMemberService")
public class RepositoryMemberServiceImpl extends BaseServiceImpl<RepositoryMemberEntity> implements RepositoryMemberService {
	@Autowired
	private RepositoryMemberDao repositoryMemberDao;
    //Custom Generate Code Start
    //Custom Generate Code End
}
