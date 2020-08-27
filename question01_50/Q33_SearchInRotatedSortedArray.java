package question01_50;

public class Q33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        // 边界问题
        if(nums == null || nums.length == 0)    return -1;

        // 找到 pivot
        int left = 0, right = nums.length - 1;
        int pivot = 0;

        while(pivot < nums.length - 1 && nums[pivot] < nums[pivot+1]){
            if(nums[pivot] == target)
                return pivot;
            pivot++;
        }

        if(nums[pivot] == target)
            return pivot;

        // 重新设定 left 和 right
        left = pivot+1;

        // 二分查找
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[left] == target)
                return left;
            if(nums[right] == target)
                return right;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }

        return -1;
    }
}
