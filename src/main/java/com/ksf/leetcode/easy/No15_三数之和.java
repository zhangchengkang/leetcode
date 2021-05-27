package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/5/26 16:06
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class No15_三数之和 {

    /**
     * 双指针  O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;  // 第一个数大于 0，后面的数都比它大，肯定不成立了

            if (i > 0 && nums[i] == nums[i - 1]) continue;//去掉重复的情况

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++; // 2层去重，111333这种情况，只需要算一次，i,j 移动到 最内部 1，3
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
