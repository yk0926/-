package com.kyong.suixianglu.e栈与队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/4 19:40
 */
//1047.删除字符串中的所有相邻重复项
public class d删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(characterStack.empty()){
                characterStack.add(s.charAt(i));
            }else {
                if(s.charAt(i) == characterStack.peek()){
                    characterStack.pop();
                }else {
                    characterStack.add(s.charAt(i));
                }
            }
        }
        int size = characterStack.size();
        char[] characters = new char[size];
        for (int i = size-1; i >=0; i--) {
            characters[i]=characterStack.pop();
        }
        return new String(characters);
    }

    //直接对数组操作
    public String removeDuplicates1(String S) {
        int index = -1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (index >= 0 && chars[index] == chars[i]) {
                index--;
            } else {
                index++;
                chars[index] = chars[i];
            }
        }
        return String.copyValueOf(chars, 0, index + 1);
    }

    //stringBuilder做栈
    public String removeDuplicates2(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

}
