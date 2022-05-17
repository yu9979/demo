package com.example.demo.test;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-03-11 15:39
 **/
public class TestMap {
    public static void main(String[] args) {


        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("", "");
        boolean asdd = TestMap.CheckPermutation("asdd", "1233");
        System.out.println(asdd);
    }

    public static boolean CheckPermutation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);

        return Arrays.equals(chars,chars1);

       /* int[] counter = new int[128];
        for (int i = 0; i < n1; ++i) {
            ++counter[s1.charAt(i)];
            --counter[s2.charAt(i)];
        }
        for (int v : counter) {
            if (v != 0) {
                return false;
            }
        }*/
        //return true;
    }

}
