package quesetion51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. N-Queens II
 */

public class Q52_NQueensII {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // 边界问题
        if(n == 0 || n == 2 || n == 3)  return 0;
        if(n == 1)  return 1;

        dfs(n, new int[n], 0, result);

        return result.size();
    }

    private static void dfs(int n, int[] queens, int row, List<List<String>> result){
        // base case
        if(n == row){
            List<String> list = new ArrayList<>();
            result.add(new ArrayList<>(list));
            return;
        }

        // 变量所有 col
        for(int i=0;i<n;i++){
            if(check(queens, row, i)){
                queens[row] = i;
                dfs(n, queens, row+1, result);
            }
        }
    }

    private static boolean check(int[] queens, int row, int col){
        for(int i=0;i<row;i++){
            if(queens[i] == col)
                return false;
            if(Math.abs(row - i) == Math.abs(col - queens[i]))
                return false;
        }
        return true;
    }
}
