package com.example.demo.copy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-18 15:01
 **/

@Getter
@Setter
@ToString
public class TargetUser {
    /**id*/
    private Long targetId;

    /**名称*/
    private String targetName;

    /**密码*/
    private String password;

    /**出生日期*/
    private Date targetBirthDay;

    /**是否健康*/
    private Boolean targetHealth;
}
