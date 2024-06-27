package com.kyong.suixianglu.g回溯算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/27 16:24
 */
//17.电话号码的字母组合
public class c电话号码的字母组合 {
    public static void main(String[] args) {

        letterCombinations("23");
    }
    static ArrayList<String> res =  new ArrayList<>();
    static LinkedList<Character> temp =  new LinkedList<>();
    static char[][] phone = new char[][]{{'a','b','c'},{'d','e','f'},
            {'g','h','i'}, {'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public static List<String> letterCombinations(String digits) {
        if(digits==null|| digits.equals("")) return res;
        char[] charArray = digits.toCharArray();
        int length = charArray.length;
        back(length,0,charArray);
        return res;
    }

    public static void back(int length, int index, char[] charArray){
        if(length==index){
            res.add(temp.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
            return;
        }
        int num = Integer.parseInt(String.valueOf(charArray[index])); //第index位数字
        char[] numChar = phone[num - 2]; //数字上的字母
        for (char c : numChar) {
            temp.add(c);
            index++; //下一位数字
            back(length,index,charArray);
            temp.removeLast();
            index--;
        }
    }
}
