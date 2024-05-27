package com.kyong.suixianglu.d字符串;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/23 15:33
 */
//28.找出字符串中第一个匹配项的下标
public class d找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        System.out.println(strStr("abc", "c"));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        int res = -1;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if (haystack.charAt(i)==needle.charAt(0)){
                for (int j = 0; j < needle.length(); j++) {
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        res = -2;
                        break;
                    }
                }
                if(res == -2){
                    res = -1;
                }else {
                    return i;
                }
            }
        }
        return res;

    }
}
