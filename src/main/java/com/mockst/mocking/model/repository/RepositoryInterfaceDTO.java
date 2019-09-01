package com.mockst.mocking.model.repository;

import lombok.Data;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/14 22:49
 * @Description:
 */
@Data
public class RepositoryInterfaceDTO {
    private String id;
    private String interfaceName;
    private String description;
    private String url;
    private String method;
    private String moduleId;
}
