package com.mockst.mocking.module.repository.service;

import com.esnotary.framework.service.BaseService;
import com.mockst.mocking.model.repository.InterfacePropertyDTO;
import com.mockst.mocking.model.repository.InterfacePropertyForm;
import com.mockst.mocking.model.repository.OutInterfaceDTO;
import com.mockst.mocking.module.repository.entity.RepositoryInterfacePropertyEntity;

import java.util.List;
//Import Package End
/**
 * repository接口参数
 * 
 * @author ${author}
 * @email ${email}
 * @date 2019-08-03 10:56:40
 */
public interface RepositoryInterfacePropertyService extends BaseService<RepositoryInterfacePropertyEntity> {

    //Custom Generate Code Start
    void updateProperty(String interfaceId, List<RepositoryInterfacePropertyEntity> properties);
    List<InterfacePropertyDTO> findProperiesByInterfaceId(String interfaceId);

    OutInterfaceDTO findByInterfaceId(String interfaceId);
    //Custom Generate Code End
}
