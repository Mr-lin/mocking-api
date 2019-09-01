package com.mockst.mocking.module.repository.service.impl;

import com.mockst.mocking.model.repository.RepositoryInfoDTO;
import com.mockst.mocking.module.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esnotary.framework.service.impl.BaseServiceImpl;

import com.mockst.mocking.module.repository.dao.RepositoryDao;
import com.mockst.mocking.module.repository.entity.RepositoryEntity;
import com.mockst.mocking.module.repository.service.RepositoryService;

import java.util.List;
import java.util.Map;
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
	@Override
	public List<Map<String, Object>> findByCondition(Map<String, Object> param) {
		return repositoryDao.findByCondition(param);
	}

	@Override
	public RepositoryInfoDTO findById(String repositoryId) {
		return repositoryDao.findById(repositoryId);
	}

	//Custom Generate Code End
}
