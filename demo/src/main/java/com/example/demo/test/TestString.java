package com.example.demo.test;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-11 10:44
 **/
public class TestString {

    public static void main(String[] args) {
        String  myStr="";

        String str="34020000001320158213,34020000001320158212,34020000001320158206,34020000001320158207,34020000001320158205,34020000001320158204,34020000001320158202,34020000001320158203,34020000001320158209,2C-6F-71_1,34020000001320158200,34020000001320158198,34020000001320158199,34020000001320158159,34020000001320158158,34020000001320158177,34020000001320158175,34020000001320158176,34020000001320158174,2C-6F-A8_1,34020000001320158171,34020000001320158170,34020000001320158172,34020000001320158173,34020000001320158178,34020000001320158179,2C-6F-68_1,34020000001320158165,34020000001320158164,34020000001320158152,34020000001320158153,34020000001320158155,2C-6F-8A_1,34020000001320109010,34020000001320158154,34020000001320158150,34020000001320158169,2C-6F-64_1,34020000001320158133,34020000001320158131,2C-6F-84_1,2C-6F-75_1,34020000001320158096,34020000001320158095,2C-6F-54_1,34020000001320109009,34020000001320158102,34020000001320158101,34020000001320158111,34020000001320158112,34020000001320158103,34020000001320158104,2C-6F-6A_1,34020000001320158108,34020000001320158105,34020000001320158107,2C-6F-5D_1,34020000001320158106,34020000001320158110,34020000001320158109,34020000001320158143,34020000001320158142,34020000001320109007,34020000001320158044,34020000001320158045,34020000001320158042,34020000001320158046,2C-6F-9D_1,34020000001320158048,34020000001320158049,34020000001320158050,2C-6F-5A_1,34020000001320158034,34020000001320158041,34020000001320158024,34020000001320158023,34020000001320158021,34020000001320158020,34020000001320158019,2C-6F-65_1,34020000001320158012,34020000001320158013,34020000001320158016,34020000001320158017,2C-6F-8B_1,34020000001320158014,34020000001320158015,34020000001320158030,34020000001320158031,34020000001320158035,34020000001320158070,34020000001320158071,34020000001320158033,2C-6F-61_1,2C-6F-6B_1,34020000001320158073,2C-6F-99_1,34020000001320158072,34020000001320158063,34020000001320158062,34020000001320158066,34020000001320158067,34020000001320158075,34020000001320158080,2C-6F-8D_1,34020000001320158081,34020000001320109001,34020000001320109002,34020000001320158076,34020000001320158077,34020000001320109005,34020000001320109006,34020000001320158086,34020000001320158087,34020000001320158088,34020000001320109003,34020000001320109004,34020000001320158079,34020000001320158068,34020000001320158069";


        String[] split = str.split(",");

        for (int i = 0; i < split.length; i++) {
           // System.out.println("'"+split[i]+"'");
            myStr=myStr+"'"+split[i]+"'";
            if(i==split.length-1){

            }else{
                myStr+=",";
            }
        }
        System.out.println("::::"+split.length);
        System.out.println("A1:"+myStr);


    }
}
