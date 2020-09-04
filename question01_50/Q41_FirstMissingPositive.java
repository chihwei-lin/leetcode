package question01_50;

import java.util.HashSet;

public class Q41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // 边界问题
        if(nums == null || nums.length == 0) return 1;

        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int i=1;i<=n;i++){
            if(!set.contains(i))
                return i;
        }

        return n+1;
    }
}
