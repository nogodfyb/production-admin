package com.fyb.production.dto;

import lombok.Data;

@Data
public class UserParam {

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

}
