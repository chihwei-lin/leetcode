package question01_50;

/**
 * 11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Hints : Two Pointer
 *
 */

public class Q11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            // 左边的高度较矮
            if(height[left] < height[right]){
                maxArea = Math.max(maxArea, height[left] * (right-left));       // 取左边的高度
                left++;         // 移动左指针
            }
            // 右边的高度较矮
            else{
                maxArea = Math.max(maxArea, height[right] * (right-left));      // 取右边的高度
                right--;        // 移动右指针
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
