package cn.wzz.interview2021;

import java.util.HashMap;
import java.util.Map;

/*
    leetcode题目：
    给定一个整数数组 nums 和一个目标值 target,请你在该数组中找出和为目标值的那两个整数,
    并返回他们的数组下标你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使
    用两遍。
* */
public class TwoSumDemo {
    public static void main(String[] args) {
        int[] nums ={2, 7, 11, 15};
        int target = 9;
        int[] indexCollection = twoSum1(nums,target);
//        int[] indexCollection = twoSum2(nums,target);
        if(indexCollection!=null){
            for (int index : indexCollection) {
                System.out.print(index+" ");
            }
        }
    }

    //1.暴力法:
    //通过双重遍历数组中所有元素的两两组合,当出现符合的和时返回两个元素的下标
    public static int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //2.哈希(更优解法)
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int param = target - nums[i];//2 7
            if(map.containsKey(param)){
                return new int[]{map.get(param),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}