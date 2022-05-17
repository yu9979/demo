package com.example.demo.test;

import java.util.HashMap;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-03-14 15:23
 **/
public class TestSort {
    public static void main(String[] args) {

        //给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
        /*
        *输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

        * */
        String s = "abcaaaahijk";
        if (s.length() < 1) {
            System.out.println("KKKKKK");
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i))+1,start);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        System.out.println(max);
        /*int n = s.length(), ans = 0;
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {        //包含键j
                i = Math.max(map.get(s.charAt(j)), i);    //比较大小
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        System.out.println(ans);*/
       /* int max = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {

            if (map.containsKey(str.charAt(i))) {
                System.out.println(map.get(str.charAt(i)));
                start = Math.max(start, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        System.out.println("::::::;" + max);*/








      /*  HashMap<Integer, Integer> map = new HashMap<>();

        int nums[] = {2, 5, 7, 11, 15};
        int target = 9;
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement) + "," + i);
            }
            map.put(nums[i], i);

        }*/


        //冒泡排序
      /*  int arr[] = {5, 8, 6, 3, 9, 2, 1, 7};


        for (int i = 0; i < arr.length; i++) {
            System.out.print("" + arr[i] + ",");
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        System.out.println("++++++++");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("" + arr[i] + ",");
        }*/
    }
}
