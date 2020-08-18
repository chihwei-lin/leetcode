package question01_50;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Solution
 * 1. create a Map
 * 2. loop through nums
 * 3. check the difference between the current number and target
 * 4. if the difference is in Map -> return Map.getValue(the current number)
 * 5. else add the current number as key and current index as value
 */


public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        // 1. create a map
        // Map is an interface, cannot create its instance
        Map<Integer, Integer> map = new HashMap<>();

        // 2. loop through nums
        for (int i = 0; i < nums.length; i++) {
            // 3. check the difference between the current number and target
            int diff = target - nums[i];

            // 4. if the difference is in Map -> return Map.getValue(the current number)
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            //  5. else add the current number as key and current index as value
            else{
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        // test 1
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));

        // test 2
        arr = new int[]{};
        target = 0;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
