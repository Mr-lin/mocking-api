package com.mockst.mocking.model.repository;

import lombok.Data;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/23 22:31
 * @Description:
 */
@Data
public class InterfacePropertyDTO {
    private String id;
    private String name;
    private String type;
    private String scope;
    private String parentId;
    private Boolean required;
    private String rule;
    private String value;
    private String description;
    private int depth;
}
