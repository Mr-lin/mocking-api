package com.mockst.mocking.model.repository;

import com.mockst.mocking.module.repository.entity.RepositoryEntity;
import com.mockst.mocking.module.repository.entity.RepositoryModuleEntity;
import com.mockst.mocking.module.user.entity.UserEntity;
import lombok.Data;

import java.util.List;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/26 20:52
 * @Description:
 */
@Data
public class RepositoryInfoDTO extends RepositoryEntity {

    private List<UserEntity> users ;
    private List<RepositoryModuleEntity> modules;

}
