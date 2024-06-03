package com.kyong.suixianglu.e栈与队列;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/29 11:41
 */
//20.有效的括号
public class c有效的括号 {
//    public boolean isValid(String s) {
//        if(s.length()%2 != 0) return false;
//        int anum = 0;
//        int bnum = 0;
//        int cnum = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '('){
//                anum++;
//            }else if(s.charAt(i) == '['){
//                bnum++;
//            }else if(s.charAt(i) == '{'){
//                cnum++;
//            }else if(s.charAt(i) == ')'){
//                anum--;
//                if(anum<0){
//                    return false;
//                }
//            }else if(s.charAt(i) == ']'){
//                bnum--;
//                if(bnum<0){
//                    return false;
//                }
//            }else if(s.charAt(i) == '}'){
//                cnum--;
//                if(cnum<0){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    public boolean isValid(String s) {
        LinkedList<Character> characters1 = new LinkedList<>();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)  == '(' || s.charAt(i)=='{' || s.charAt(i) == '['){
                characters.add(s.charAt(i));
            }else if (s.charAt(i)==')' && (characters.empty() || characters.pop()!= '(')){
                return false;
            }else if(s.charAt(i)==']'&& (characters.empty() ||characters.pop()!= '[')){
                return false;
            }else if(s.charAt(i)=='}'&& (characters.empty() ||characters.pop()!= '{')){
                return false;
            }
        }
        return characters.empty();
    }
}
