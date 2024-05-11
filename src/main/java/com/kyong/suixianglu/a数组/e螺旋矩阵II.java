package com.kyong.suixianglu.a数组;

/**
 * @author kyong
 * @date 2023/3/24 15:51
 */
//59.螺旋矩阵II
public class e螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int total = n*n;
        int start = 1;
        int l = 0;
        int r = n-1;
        int t = 0;
        int b = n-1;
        while (start<=total){
            for (int i = l; i <= r; i++) {
                res[t][i] = start++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = start++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                res[b][i] = start++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                res[i][l] = start++;
            }
            l++;
        }
        return res;
    }
}
