package question01_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 *
 * [1,1,2] -> [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */

public class Q47_PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界问题
        if(nums == null | nums.length == 0) return result;

        Arrays.sort(nums);
        dfs(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);

        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1])   continue;

            used[i] = true;
            list.add(nums[i]);

            dfs(nums, result, list, used);

            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
