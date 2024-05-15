package com.kyong.suixianglu.c哈希表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/15 16:07
 */
//202.快乐数
public class c快乐数 {
    public static void main(String[] args) {
        System.out.println(isHappy2(19));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> nums = new HashSet<>();
        int sum = 0;
        while (true){
            char[] numchar = String.valueOf(n).toCharArray();
            for (char c : numchar) {
                Integer num = Integer.valueOf(String.valueOf(c));
                sum+= num*num;
            }
            if(sum ==1){
                return true;
            }
            if(nums.contains(sum)){
                return false;
            }
            nums.add(sum);
            n = sum;
            sum=0;
        }
    }

    public static  boolean isHappy2(int n) {
        HashSet<Integer> nums = new HashSet<>();
        while (n != 1 && !nums.contains(n) ){
            nums.add(n);
            n=getNext(n);
        }
        return n == 1;
    }

    public static  int getNext(int n){
        int sum =0;
        while (n>0){
            int i = n % 10;
            sum += i*i;
            n = n/10;
        }
        return sum;
    }
}
