package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2020/8/21 11:17
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 假设每种输入只会对应一个答案。不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class No1_TwoSum {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;
        System.out.println(Arrays.toString(solution2(nums, target)));
    }

    /**
     * 时间复杂度：两层for循环，O（n²）
     *
     * 空间复杂度：O(1)。
     */
    public static int[] solution1(int[] nums, int target) throws Exception {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new Exception("no two sum solution");
    }

    /**
     * 判断target-当前遍历值在不在hash里
     * 在--返回  不在--存入hash(数组值为key,下标为value)
     *
     * 时间复杂度：O(n)，
     * 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间
     *
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
     */
    public static int[] solution2(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new Exception("no two sum solution");
    }
}
