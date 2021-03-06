package com.mockst.mocking.module.repository.dao;

import com.mockst.mocking.model.repository.InterfacePropertyDTO;
import com.mockst.mocking.module.repository.entity.RepositoryInterfacePropertyEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
//Import Package End
/**
 * repository接口参数
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
public interface RepositoryInterfacePropertyDao extends Mapper<RepositoryInterfacePropertyEntity> {

    //Custom Generate Code Start
    List<InterfacePropertyDTO> findProperiesByInterfaceId(String interfaceId);
    //Custom Generate Code End
}
