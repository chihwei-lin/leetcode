package question01_50;

import java.util.List;
import java.util.ArrayList;

/**
 * 26. Remove Duplicates from Sorted Array
 * 只能使用 nums，不能新建其他
 *
 * 1：计算非重复元素个数
 * 2：去重
 */

public class Q26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // 边界问题
        if(nums.length < 2)     return nums.length;

        int n = nums.length;
        int count = 0;
        int pointer1 = 0, pointer2 = 0;

        while(pointer2 < n){
            nums[pointer1] = nums[pointer2];

            while(pointer2 < n && nums[pointer1] == nums[pointer2])
                pointer2++;
            pointer1++;
        }

        return pointer1;
    }
}
