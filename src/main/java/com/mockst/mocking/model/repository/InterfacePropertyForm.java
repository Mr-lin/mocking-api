package com.mockst.mocking.model.repository;

import lombok.Data;

import java.util.List;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/23 22:42
 * @Description:
 */
@Data
public class InterfacePropertyForm {
    private String interfaceId;
    private List<InterfacePropertyDTO> requestProperties;
    private List<InterfacePropertyDTO> responseProperties;
}
