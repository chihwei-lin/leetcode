package question01_50;

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParanthesesRecursion(result, "", 0, 0, n);
        return result;
    }

    private static void generateParanthesesRecursion(List<String> result, String sub_str, int left, int right, int n){
        // 递归的终止条件
        if(left + right == 2 * n){
            result.add(sub_str);
            return;
        }

        // 情况有 1： left 和 right 都小于 3。  2：left 等于 n，right 小于 3
        if(left < n)
            generateParanthesesRecursion(result, sub_str+"(", left+1, right, n);
        if(left > right)
            generateParanthesesRecursion(result, sub_str+")", left, right+1, n);
    }
}
