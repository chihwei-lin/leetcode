package question01_50;

import java.util.Arrays;

public class Q16_3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        // 三指针解法

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int left = i+1, right=n-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = target-sum;

                // 情况有三种 1：target 和 sum 的差等于零 2：差大于零
                if(diff == 0)
                    return sum;
                else if(diff > 0){
                    left++;
                }else if(diff < 0){
                    right--;
                }
                closestSum = (Math.abs(diff) < Math.abs(target - closestSum)) ? sum : closestSum;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));          // 2

        nums = new int[]{0,2,1,-3};
        target = 1;
        System.out.println(threeSumClosest(nums, target));          // 0

        nums = new int[]{-3, -2, -5, 3, -4};
        target = -1;
        System.out.println(threeSumClosest(nums, target));          // -2
    }
}
