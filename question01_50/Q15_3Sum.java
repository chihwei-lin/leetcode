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


public class Q15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 用 三指针 找出所有计算组合
        List<List<Integer>> list = new ArrayList<>();

        // 对数组排序
        Arrays.sort(nums);

        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(i == 0 || nums[i] != nums[i-1]){     // 去重
                int left = i+1, right = n-1;        // 三指针
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    // 情况有三种 1. 等于 0  2. 大于 0  3. 小于 0
                    if(sum == 0){
                        List<Integer> tmp = new ArrayList<Integer>(List.of(nums[i], nums[left], nums[right]));
                        list.add(tmp);

                        left++;
                        right--;

                        // 去重
                        while(left < right && nums[left] == nums[left-1])   left++;
                        while(right > left && nums[right] == nums[right+1]) right--;
                    }else if(sum > 0)
                        right--;
                    else
                        left++;
                }
            }
        }
        return list;
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
