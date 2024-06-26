package com.kyong.suixianglu.h贪心算法;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/20 16:29
 */
//376.摆动序列
public class b摆动序列 {
    public static void main(String[] args) {
    }
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<=1)return 1;
        int index = 1;
        while (index<nums.length && nums[index] == nums[index-1]){
            index++;
        }
        if(index==nums.length){
            return 1;
        }
        int res = 2;
        boolean pre = nums[index] - nums[index-1] > 0; //之前是否增
        for (int i = index; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) continue; //等于，直接跳过
            boolean temp = nums[i]-nums[i-1] > 0; //当前是否增
            if(pre){  //之前增
                if(!temp){ //现在减
                    res++;
                    pre = false; //之前变减
                }
            }else { //之前减
                if(temp){ //现在增
                    res++;
                    pre = true; //之前变增
                }
            }
        }
        return res;
    }
}
