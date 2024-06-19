package com.kyong.suixianglu.h贪心算法;

import java.util.Arrays;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/17 15:09
 */
public class a分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int indexG = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] >= g[indexG]){
                res++;
                indexG++;
            }
            if(indexG > g.length-1){
                break;
            }
        }
        return res;
    }
}
