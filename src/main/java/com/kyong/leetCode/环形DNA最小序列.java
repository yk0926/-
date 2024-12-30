package com.kyong.leetCode;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/12/30 17:08
 */

public class 环形DNA最小序列 {
    public static String findMin(String s) {
        int n = s.length();
        s += s;
        String min = s.substring(0, n);
        for (int i = 1; i < n; i++) {
            String temp = s.substring(i, i + n);
            if (temp.compareTo(min) < 0) {
                min = temp;
            }
        }
        return min;
    }

    public static String solution(String s) {
        // Please write your code here
        if (s == null || s.length() == 0)
            return "";

        int n = s.length();
        int i = 0, j = 1, k = 0;

        while (i < n && j < n && k < n) {
            int diff = s.charAt((i + k) % n) - s.charAt((j + k) % n);
            if (diff == 0) {
                k++;
            } else {
                if (diff > 0) {
                    i += k + 1;
                } else {
                    j += k + 1;
                }
                if (i == j)
                    j++;
                k = 0;
            }
        }
        int minIndex = Math.min(i, j);
        return s.substring(minIndex) + s.substring(0, minIndex);
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(findMin("ATCA").equals("AATC"));
        System.out.println(findMin("CGAGTC").equals("AGTCCG"));
        System.out.println(
                findMin("TCATGGAGTGCTCCTGGAGGCTGAGTCCATCTCCAGTAG").equals("AGGCTGAGTCCATCTCCAGTAGTCATGGAGTGCTCCTGG"));
    }
}