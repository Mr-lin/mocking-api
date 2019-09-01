package com.mockst.mocking.model.repository;

import lombok.Data;

import java.util.List;

/**
 * @Auther: zhiwei
 * @Date: 2019/9/1 16:58
 * @Description:
 */
@Data
public class OutInterfaceDTO {
    private String interfaceName;
    private String url;
    private String description;
    private String responseExample;
    private List<InterfacePropertyDTO> requestProperties;
    private List<InterfacePropertyDTO> responseProperties;
}
