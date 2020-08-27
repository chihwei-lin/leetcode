package question01_50;

/**
 * 35. Search Insert Position
 *
 * 找出 target 在 nums 的下标
 * 没有则返回 target 应该要在的位置
 *
 */

public class Q35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // 边界问题
        if(nums == null || nums.length == 0)    return 0;

        int n = nums.length;

        //  判断 target 是否小于 nums[0] 或大于 nums 最后一个元素
        if(target < nums[0])    return 0;
        if(target > nums[n-1])  return n;

        int left = 0, right = n-1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[left] == target)    return left;
            if(nums[right] == target)   return right;
            if(nums[mid] == target)     return mid;

            if(mid > 0 && nums[mid] > target && nums[mid-1] < target)
                return mid;
            if(mid < n-1 && nums[mid] < target && nums[mid+1] > target)
                return mid + 1;

            if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }

        return -1;
    }
}
