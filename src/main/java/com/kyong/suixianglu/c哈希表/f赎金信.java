package com.kyong.suixianglu.c哈希表;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/16 20:26
 */
public class f赎金信 {
    public static void main(String[] args) {
        canConstruct("aa","aab");
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charNums = new int[26];
        int ransomNoteLength = ransomNote.length();
        for (int i = 0; i < ransomNoteLength; i++) {
            charNums[ransomNote.charAt(i) - 'a'] ++;
        }
        int magazineLength = magazine.length();
        for (int i = 0; i < magazineLength; i++) {
            charNums[magazine.charAt(i) - 'a'] --;
        }
        for (int charNum : charNums) {
            if(charNum>0){
                return false;
            }
        }
        return true;
    }
}
