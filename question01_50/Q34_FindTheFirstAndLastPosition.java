package question01_50;

public class Q34_FindTheFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        // 边界问题
        if(nums == null || nums.length == 0)    return new int[]{-1, -1};

        int left = 0, right = nums.length-1;
        int index = -1;
        // 用二分法找出 target，以该 index
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[left] == target){
                index = left;
                break;
            }
            else if(nums[right] == target){
                index = right;
                break;
            }

            if(nums[mid] == target){
                index = mid;
                break;
            }
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }

         if(index == -1)
             return new int[]{-1, -1};

        // 找到与 target 相同的元素位置，平行左右扩张
        left = index;
        right = index;

        while(left > 0 && nums[left] == nums[left-1])
            left--;
        while(right < nums.length-1 && nums[right] == nums[right+1])
            right++;

        return new int[]{left, right};
    }
}
