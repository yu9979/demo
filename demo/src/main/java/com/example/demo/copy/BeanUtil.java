package com.example.demo.copy;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-18 15:05
 **/
public class BeanUtil {

    /**
     * <h3>拷贝一个对象的属性至另一个对象</h3>
     * <p>
     * 支持两个对象之间不同属性名称进行拷贝，使用注解{@link FieldAlias}
     * </p>
     *
     * @param originBean 源对象
     * @param targetBean 目标对象
     */
    public static void copyBean(Object originBean, Object targetBean) {
        Map<String, Object> originFieldKeyWithValueMap = new HashMap<>(16);
        PropertyDescriptor propertyDescriptor = null;
        //生成源bean的属性及其值的字典
        operateBeanFieldWithValue(originBean,
                propertyDescriptor,
                originFieldKeyWithValueMap,
                originBean.getClass(),
                (bean, descriptor, realFieldName, fieldWithMethodMap)-> {
                    try {
                        //获取当前属性的get方法
                        Method method = descriptor.getReadMethod();
                        //设置值
                        Object value = method.invoke(bean);
                        //将源对象值缓存设置值
                        fieldWithMethodMap.put(realFieldName, value);
                    } catch (IllegalAccessException e) {
                        System.err.println("【源对象】异常:" + realFieldName + "的get方法执行失败！");
                    } catch (InvocationTargetException e) {
                        System.err.println("【源对象】异常:" + realFieldName + "的get方法执行失败！");
                    }
                }
        );
        //设置目标bean的属性值
        operateBeanFieldWithValue(targetBean, propertyDescriptor, originFieldKeyWithValueMap, targetBean.getClass(),
                (bean, descriptor, realFieldName, fieldWithMethodMap)-> {
                    try {
                        //获取当前属性的set方法
                        Method method = descriptor.getWriteMethod();
                        method.invoke(bean, fieldWithMethodMap.get(realFieldName));
                    } catch (IllegalAccessException e) {
                        System.err.println("【目标对象】异常:" + realFieldName + "的set方法执行失败！");
                    } catch (InvocationTargetException e) {
                        System.err.println("【目标对象】异常:" + realFieldName + "的set方法执行失败！");
                    }
                });

    }

    /**
     * 操作bean
     * 对于源对象：生成需要被拷贝的属性字典 属性-属性值，递归取父类属性值
     * 对于目标对象：设置源对象的属性值
     * @param bean                 当前被操作的bean
     * @param descriptor         属性描述器，可以获取bean中的属性及方法
     * @param originFieldNameWithValueMap 存放待拷贝的属性和属性值
     * @param beanClass                  被操作的class[可能是超类的class]
     */
    private static void operateBeanFieldWithValue(Object bean,
                                                  PropertyDescriptor descriptor,
                                                  Map<String, Object> originFieldNameWithValueMap,
                                                  Class<?> beanClass,
                                                  CVFunction cvFunction
    ) {
        /**如果不存在超类，那么跳出循环*/
        if (beanClass.getSuperclass() == null) {
            return;
        }
        Field[] fieldList = beanClass.getDeclaredFields();
        for (Field field : fieldList) {
            try {
                /*获取属性上的注解。如果不存在，使用属性名，如果存在使用注解名*/
                FieldAlias fieldAlias = field.getAnnotation(FieldAlias.class);
                String realFieldName = Objects.isNull(fieldAlias) ? field.getName() : fieldAlias.value();
                //初始化
                descriptor = new PropertyDescriptor(field.getName(), beanClass);
                cvFunction.apply(bean, descriptor, realFieldName, originFieldNameWithValueMap);
            } catch (IntrospectionException e) {
                System.err.println("【源对象】异常:" + field.getName() + "不存在对应的get方法，无法参与拷贝！");
            }
        }
        //生成超类 属性-value
        operateBeanFieldWithValue(bean, descriptor, originFieldNameWithValueMap, beanClass.getSuperclass(), cvFunction);
    }
}

