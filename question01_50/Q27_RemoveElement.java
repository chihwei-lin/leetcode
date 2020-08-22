package question01_50;

/**
 * 27. Remove Element
 *
 * 解法：双指针
 *
 */

public class Q27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 边界问题
        if(nums.length < 1)    return 0;

        int pointer1 = 0, pointer2 = 0;
        int n = nums.length;

        // pointer1 递增为 1，pointer2 则跳过与 val 相同值
        while(pointer2 < n){
            // 防止第一个元素等于 val
            if(nums[pointer2] == val){
                pointer2++;
                continue;
            }

            nums[pointer1] = nums[pointer2];
            pointer1++;
            pointer2++;
        }
        return pointer1;
    }
}
