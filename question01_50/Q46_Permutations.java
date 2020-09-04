package question01_50;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // 边界问题
        if(nums == null || nums.length == 0)    return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        permutation(nums, result, 0);

        return result;
    }

    private static void permutation(int[] nums, List<List<Integer>> result, int startIndex){
        if(startIndex == nums.length){
            List<Integer> list = new ArrayList<>();

            for(Integer num: nums)
                list.add(num);

            result.add(list);
            return;
        }

        for(int i=startIndex;i<nums.length;i++){
            swap(nums, i, startIndex);
            permutation(nums, result, startIndex+1);
            swap(nums, i, startIndex);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

    }
}
