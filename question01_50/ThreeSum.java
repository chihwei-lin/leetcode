package question01_50; /**
 * 15. 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 *
 * Related Topics : Array, Two Pointers
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. 对 nums 排序
        Arrays.sort(nums);

        int start, end, sum;

        // 2. 遍历 nums 从零到 nums.length - 2
        for (int i = 0; i < nums.length - 2; i++) {
            // 3. if nums[i] == nums[i-1], skip
            if (i == 0 || nums[i] != nums[i - 1]) {

                // 双指针 start 和 end
                start = i + 1;
                end = nums.length - 1;

                // 移动 start 和 end 指针，组成所有可能的 3 个元素
                while (start < end) {
                    sum = nums[i] + nums[start] + nums[end];
                    if (sum < 0)
                        start++;
                    else if (sum > 0)
                        end--;
                    else {
                        List<Integer> list = new ArrayList<Integer>(List.of(nums[i], nums[start], nums[end]));
                        result.add(list);
                        start++;
                        end--;

                        // 去重
                        while (start < end && nums[start] == nums[start - 1])
                            start++;
                        while (start < end && nums[end] == nums[end + 1])
                            end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};

        // test 1
        System.out.println(threeSum(array));

        // test 2
        array = new int[]{0,0,0};
        System.out.println(threeSum(array));

        // test 3
        array = new int[]{1,-1,-1,0};
        System.out.println(threeSum(array));
    }
}
