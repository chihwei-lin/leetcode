package question01_50;

import java.util.Arrays;

/**
 * 45. Jump Game II
 *
 * 用最小步数达到最后的 index
 *
 * [2,3,1,1,4] -> 2
 *
 * 跳出界 怎么处理？
 * You can assume that you can always reach the last index.
 */

public class Q45_JumpGameII {
    public static int jump(int[] nums) {
        // 边界问题
        if(nums == null || nums.length < 2)    return 0;

        int n = nums.length;
        int[] jump = new int[n];

        for(int i=0;i<n;i++)
            jump[i] = i;

        for(int i=0;i<n-1;i++){
            int jumpIndex = i + nums[i];
            jumpIndex = (jumpIndex < n) ? jumpIndex : n-1;

            jump[jumpIndex] = Math.min(jump[i] + 1, jump[jumpIndex]);

            for(int j=i+1;j<jumpIndex;j++){
                if(jump[j] > jump[jumpIndex])
                    jump[j] = jump[jumpIndex];
            }
        }
        System.out.println(Arrays.toString(jump));
        return jump[n-1];
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{4,1,1,3,1,1,1}));
    }
}
