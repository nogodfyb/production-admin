package com.fyb.production.vo;

import lombok.Data;

@Data
public class UserVo {
    private Integer id;

    /**
     * 用户姓名
     */
    private String username;


    /**
     * 邮箱号码
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户角色名称
     */
    private String roleName;

    /**
     * 1代表可以使用，0代表封禁
     */
    private Boolean isAlive;
}
