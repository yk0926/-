package com.kyong.suixianglu.d字符串;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/23 11:07
 */
//344.反转字符串
public class a反转字符串 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
