package com.kyong.suixianglu.d字符串;

import java.util.HashMap;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/27 11:30
 */
//459.重复的子字符串
public class e重复的子字符串 {
    public static void main(String[] args) {
        repeatedSubstringPattern("abab");
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len == 1){
            return false;
        }
        for (int i = 1; i <= len/2; i++) {
            if(s.charAt(i) == s.charAt(0) && len%i == 0 ){
                int num = len / i;
                String s1 = s.substring(0, i);
                boolean flag = true;
                for (int j = 0; j < num; j++) {
                    String substring = s.substring(j * i, i * (j + 1));
                    if(!substring.equals(s1)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
}

