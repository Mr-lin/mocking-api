package com.mockst.mocking.model;

import lombok.Data;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/4 21:50
 * @Description:
 */
@Data
public class UserVO {
    private String id;
    private String username;
    private String email;
    private String realName;
    private String departmentId;
    private String roleId;
    private String photo;
}
