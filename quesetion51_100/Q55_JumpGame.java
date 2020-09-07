package quesetion51_100;

public class Q55_JumpGame {
    public boolean canJump(int[] nums) {
        // 边界问题
        if(nums == null || nums.length == 0 || nums.length == 1)    return true;

        int n = nums[0], i = 0;
        while(i<n){
            if(i + nums[i] >= nums.length-1)
                return true;
            i++;
        }

        return false;
    }
}
