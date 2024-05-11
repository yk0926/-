package com.kyong.suixianglu.array;

public class b移除元素 {
    //24 移除元素
    //自己写的
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        int count = 0;
        while(i<len){
            if(nums[i]!=val){
                i++;
                count++;
            }else{
                int j = i+1;
                while(j<len){
                    if(nums[j]!=val){
                        nums[i]=nums[j];
                        nums[j]=val;
                        count++;
                        break;
                    }else{
                        j++;
                    }
                }
                i++;
            }
        }
        return count;
    }

    public int removeElement(int[] nums, int val,boolean ans) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
