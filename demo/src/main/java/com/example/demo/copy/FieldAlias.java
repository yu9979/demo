package com.example.demo.copy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-18 15:02
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAlias {
    // 属性别名
    String value();
}
