package com.mockst.mocking.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/4 21:50
 * @Description:
 */
@Data
public class UserVO {
    private String id;
    @Length(min = 4,max = 20,message = "用户名长度4-20")
    private String username;
    private String email;
    private String realName;
    private String departmentId;
    private String roleId;
    private String photo;
}
