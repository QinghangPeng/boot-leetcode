package com.boot.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _1Twosum
 * @Description:
 * @Author: jackson
 * @Date: 2020/7/15 下午2:55
 * @Version: v1.0
 */
public class _1Twosum {

    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //
    // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    //
    //
    //
    // 示例:
    //
    // 给定 nums = [2, 7, 11, 15], target = 9
    //
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    //
    // Related Topics 数组 哈希表
    public static int[] twosum(int[] nums,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k)) {
                return new int[] {map.get(k),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("没有符合的参数");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int targer = 9;
        int[] result = twosum(nums, targer);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
