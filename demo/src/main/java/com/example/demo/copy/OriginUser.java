package com.example.demo.copy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-18 14:59
 **/
@Getter
@Setter
@ToString
public class OriginUser {
    /**
     * id
     */
    @FieldAlias("targetId")
    private Long originId;

    /**
     * 名称
     */
    @FieldAlias("targetName")
    private String originName;

    /**
     * 密码
     */

    private String password;

    /**
     * 出生日期
     */
    @FieldAlias("targetBirthDay")
    private Date originBirthDay;

    /**
     * 是否健康
     */
    @FieldAlias("targetHealth")
    private Boolean originHealth;
}

