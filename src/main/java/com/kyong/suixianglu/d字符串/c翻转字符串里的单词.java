package com.kyong.suixianglu.d字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/23 11:41
 */
//151.翻转字符串里的单词
public class c翻转字符串里的单词 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = split.length-1; i >=0; i--) {
            if(split[i].equals(" ")||split[i].equals("")||split[i]==null){
                continue;
            }
            else {
                list.add(split[i]);
            }
        }
        StringBuilder s2 = new StringBuilder();
        for (String s1 : list) {
            s2.append(s1).append(" ");
        }
        s2.deleteCharAt(s2.lastIndexOf(" "));
        return s2.toString();

    }
}
