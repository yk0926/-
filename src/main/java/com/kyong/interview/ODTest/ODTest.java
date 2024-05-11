package com.kyong.interview.ODTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author kyong
 * @date 2023/2/16 11:25
 */
public class ODTest {

    @Test
    public void test01(){
        int a = 5;
        int b = 20;
        int C;
        int B;
        int A;
        boolean flag = false;
        for (A = a; A < b-1 ; A++) {
            for (B = A+1; B< b;B++){
                for (C = B+1; C <= b; C++) {
                    if(noGongYue(A,B)&&noGongYue(A,C)&&noGongYue(C,B)&&judge(A,B,C)){
                        System.out.println(A+","+B+","+C);
                        flag = true;
                    }
                }
            }
        }
        if(!flag){
            System.out.println("Na");
        }
    }

    public boolean noGongYue(int A, int B){
        if(A<B){
            return noGongYue(B,A);
        }
        int z ;
        while (A%B!=0){
            z = A%B;
            A = B;
            B = z;
        }
        return B==1;
    }

    public boolean judge(int A,int B, int C){
        if((A*A+B*B)==C*C){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(test004(n));
    }

    /*
        为了充分发挥GPU算力，
        需要尽可能多的将任务交给GPU执行，
        现在有一个任务数组，
        数组元素表示在这1s内新增的任务个数，
        且每秒都有新增任务，
        假设GPU最多一次执行n个任务，
        一次执行耗时1s，
        在保证GPU不空闲的情况下，最少需要多长时间执行完成。
    */
    static void test005(){

    }

    /*
    一天一只顽猴想要从山脚爬到山顶，
    途中经过一个有n个台阶的阶梯，
    但是这个猴子有个习惯，每一次只跳1步或3步
    试问？猴子通过这个阶梯有多少种不同的跳跃方式
    *
    * */
    static int test004(int n){
        if(n<1){
            System.out.println("正整数，谢谢");
            return 0;
        }
        else if(n<=2){
            return 1;
        }else if(n==3) {
            return 2;
        }else {
            return test004(n - 3) + test004(n - 1);
        }
    }

    /*
    给定两个整数数组 array1 array2
    数组元素按升序排列
    假设从array1 array2中分别取出一个元素可构成一对元素
    现在需要取出K个元素
    并对取出的所有元素求和
    计算和的最小值
    注意：
    两对元素如果对应于array1 array2中的两个下标均相同，则视为同一个元素
    */
    /*
    * Scanner input = new Scanner(System.in);
        String arrayA = input.nextLine();
        String arrayB = input.nextLine();
        int k = input.nextInt();
        String[] s1 = arrayA.split(" ");
        String[] s2 = arrayB.split(" ");
        int[] arrA = new int[s1.length];
        int[] arrB = new int[s2.length];
        for (int i = 0; i<s1.length; i++){
            arrA[i]=Integer.valueOf(s1[i]);
        }
        for (int i = 0; i<s2.length; i++){
            arrB[i]=Integer.valueOf(s2[i]);
        }
        System.out.println(test002(arrA, arrB, k));*/
    static int test002(int[] arrayA, int[] arrayB, int k){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                list.add(arrayA[i]+arrayB[j]);
            }
        }
        System.out.println(list.toString());
        list.sort((Comparator.comparingInt(o -> o)));
        System.out.println(list.toString());
        list.sort((integer, anotherInteger) -> integer.compareTo(anotherInteger));
        Collections.sort(list);
        int result = 0;
        for (int i = 0; i < k; i++) {
            result+=list.get(i);
        }
        return result;
    }

    /*
    *   TLV编码是按TagLengthValue格式进行编码的。
        一段码流中的信元用tag标识，tag在码流中唯一不重复，
        length表示信元value的长度，value表示信元的值，
        码流以某信元的tag开头，tag固定占一个字节，length固定占两个字节，字节序为小端序。
        现给定tlv格式编码的码流以及需要解码的信元tag，请输出该信元的value。

        输入码流的十六进制字符中，不包括小写字母；
        且要求输出的十六进制字符串中也不要包含小写字母；
        码流字符串的最大长度不超过50000个字节。*/
    static void test003(String tag, String[] data){
        for (int i = 0; i < data.length;) {
            if(data[i].equals( tag)){
                int len = Integer.valueOf(data[i + 2] + data[i + 1], 16);
                StringBuilder res = new StringBuilder();
                for (int j = 0; j<len ; j++){
                    res.append(data[i + 3 + j]).append(" ");
                }
                System.out.println(res);
                break;
            }else {
                int len = Integer.valueOf(data[i + 2] + data[i + 1], 16);
                i+=(len+3);
            }
        }

    }
}
