package com.example.demo.copy;

import java.beans.PropertyDescriptor;
import java.util.Map;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-18 15:07
 **/

@FunctionalInterface
public interface CVFunction {
    /**
     * 执行CV操作
     *
     * @param bean
     * @param descriptor
     * @param realFieldName
     * @param fieldWithMethodMap
     */
    void apply(Object bean, PropertyDescriptor descriptor, String realFieldName, Map<String, Object> fieldWithMethodMap);
}

