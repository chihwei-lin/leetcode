package question01_50;

import java.util.Map;

public class Q42_TrappingRainWater {
    public int trap(int[] height) {
        // 边界问题
        if (height == null || height.length == 0 || height.length == 1) return 0;

        // 创建 left 和 right 指针
        int left = 0, right = height.length - 1;
        int max_left = height[left];
        int max_right = height[right];

        int area = 0;

        while(left < right){
            if(max_left < max_right){
                area += max_left - height[left];
                max_left = Math.max(max_left, height[++left]);
            }else{
                area += max_right - height[right];
                max_right = Math.max(max_right, height[--right]);
            }
        }

        return area;
    }
}
