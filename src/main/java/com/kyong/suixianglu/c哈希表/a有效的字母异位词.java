package com.kyong.suixianglu.c哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/14 16:53
 */
//242.有效的字母异位词
public class a有效的字母异位词 {
    public static void main(String[] args) {
        boolean anagram = isAnagram("aaa", "ba");
        System.out.println(anagram);
    }
    //暴力
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character,Integer> keys= new HashMap<>();
        Map<Character,Integer> keyt= new HashMap<>();
        for (int i = 0; i<s.length();i++){
            if(keys.containsKey(s.charAt(i))){
                keys.put(s.charAt(i), keys.get(s.charAt(i))+1 );
            }else{
                keys.put(s.charAt(i),1);
            }
            if(keyt.containsKey(t.charAt(i))){
                keyt.put(t.charAt(i), keyt.get(t.charAt(i))+1 );
            }else{
                keyt.put(t.charAt(i),1);
            }
        }
        for (Character character : keys.keySet()) {
            if(!keys.get(character).equals(keyt.get(character))){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)-'a']++;
            ints[t.charAt(i)-'a']--;
        }
        for (int anInt : ints) {
            if(anInt!=0){
                return false;
            }
        }
        return true;
    }

}
