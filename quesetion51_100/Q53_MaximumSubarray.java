package quesetion51_100;

public class Q53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // 边界问题
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];

        // 动态规划
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];            // 头个元素必须加入至数组中

        int result = -1;
        for(int i=1;i<n;i++){
            int sum = dp[i-1] + nums[i];
            dp[i] = Math.max(nums[i], sum);
            result = Math.max(dp[i], result);
        }

        return result;
    }
}
