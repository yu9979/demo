package com.example.demo.copy;

import java.util.Date;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-18 14:58
 **/
public class TestCopy {

    public static void main(String[] args) {
        OriginUser originUser = new OriginUser();
        originUser.setOriginId(1L);
        originUser.setOriginName("卡诺来了");
        originUser.setPassword("123");
        originUser.setOriginBirthDay(new Date());
        originUser.setOriginHealth(Boolean.TRUE);

        // OriginUser(originId=1, originName=卡诺来了, password=123, originBirthDay=Sat Feb 12 22:08:46 CST 2022, originHealth=true)
        System.out.println(originUser);

        // 将originUser的属性值拷贝到targetUser中
        TargetUser targetUser = new TargetUser();

        // ===========执行拷贝================
        BeanUtil.copyBean(originUser, targetUser);
        // TargetUser(targetId=1, targetName=卡诺来了, password=123, targetBirthDay=Sat Feb 12 22:08:46 CST 2022, targetHealth=true)
        System.out.println(targetUser);

    }
}
