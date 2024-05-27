package com.kyong.suixianglu.d字符串;

import java.util.Arrays;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/23 11:13
 */
//541.反转字符串II
public class b反转字符串II {
    public static void main(String[] args) {
        reverseStr("abcdefg",2);

    }
    public static String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int length = s.length();
        int num = 0;
        while (length>= 2*k){
            int left = num*2*k;
            int right = num*2*k+k-1;
            while (left<right){
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
            num++;
            length-= 2*k;
        }
        if(length>=k){
            int left = num*2*k;
            int right = num*2*k+k-1;
            while (left<right){
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }else {
            int left = num*2*k;
            int right = charArray.length-1;
            while (left<right){
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);
    }

    //官方
    public String reverseStr2(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
