package question01_50;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * 问题与 3 Sum 相似，可用同样思路解决
 * 四指针方法
 */

public class Q18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        int n = nums.length;
        for(int i=0;i<n-3;i++){                             // 指针 1
            if(i == 0 || nums[i] != nums[i-1]){
                for(int j=i+1;j<n-2;j++){                   // 指针 2
                    if(j == i+1 || nums[j] != nums[j-1]){
                        int left = j+1, right = n-1;        // 指针 3，4

                        while(left < right){
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];

                            // 情况有三种 1：target 与 sum 的差 = 0  2： > 0  3： < 0
                            if(sum == target){
                                List<Integer> tmp = new ArrayList<>();
                                tmp.add(nums[i]);
                                tmp.add(nums[j]);
                                tmp.add(nums[left]);
                                tmp.add(nums[right]);
                                result.add(tmp);

                                left++;
                                right--;

                                // 去重（与上一元素相同）
                                while(left < right && nums[left] == nums[left-1])
                                    left++;
                                while(right > left && nums[right] == nums[right+1])
                                    right--;
                            }
                            else if(sum < target)
                                left++;
                            else
                                right--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;


    }
}
