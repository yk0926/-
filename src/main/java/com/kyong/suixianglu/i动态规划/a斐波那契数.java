package com.kyong.suixianglu.i动态规划;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/19 16:22
 */

//509.斐波那契数
public class a斐波那契数 {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }

    public int fib2(int n) {
        if(n==0) return 0;
        int[] arr = new int[n + 1];
        for (int i : arr) {
            i = 0;
        }
        return helper(arr,n);
    }

    public int helper(int[] arr, int n){
        if(n < 2) return n;
        if(arr[n] != 0) return arr[n];
        arr[n] = helper(arr, n -1)+helper(arr,n-2);
        return arr[n];
    }

    public int fib3(int n) {
        if(n<2) return n;
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
