package question01_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * 解答中不能有重复的答案
 */

public class Q40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return result;

        Arrays.sort(candidates);

        combination(candidates, target, result, new ArrayList<Integer>(), 0);

        return result;
    }

    private void combination(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination, int index){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0)
            return;

        for(int i=index;i<candidates.length;i++){
            if(i == index || candidates[i] != candidates[i-1]){
                combination.add(candidates[i]);
                combination(candidates, target - candidates[i], result, combination, index+1);
                combination.remove(combination.size()-1);
            }
        }
    }
}
