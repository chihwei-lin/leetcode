package question01_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界问题
        if(candidates == null || candidates.length == 0 || target == 0)    return result;

        Arrays.sort(candidates);

        // 计算所有可能性
        combinations(candidates, result, target, 0, new ArrayList<>());

        return result;
    }

    private void combinations(int[] candidates, List<List<Integer>> result, int target, int startIndex, List<Integer> combination){
        // base case
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            int num = candidates[i];
            if(num > target)
                return;
            combination.add(num);
            combinations(candidates, result, target-num, i, combination);
            combination.remove(combination.size()-1);
        }
    }
}
