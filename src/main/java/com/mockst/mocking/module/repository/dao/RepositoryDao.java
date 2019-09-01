package com.mockst.mocking.module.repository.dao;

import com.mockst.mocking.model.repository.RepositoryInfoDTO;
import com.mockst.mocking.module.repository.entity.RepositoryEntity;
import com.mockst.mocking.module.user.entity.UserEntity;
import tk.mybatis.mapper.common.Mapper;

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
public interface RepositoryDao extends Mapper<RepositoryEntity> {

    //Custom Generate Code Start
    List<Map<String,Object>> findByCondition(Map<String, Object> param);
    RepositoryInfoDTO findById(String repositoryId);
    //Custom Generate Code End
}
