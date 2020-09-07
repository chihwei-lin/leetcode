package quesetion51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51_NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // 边界问题
        if(n == 0)  return result;

        dfs(n, new int[n], 0, result);

        return result;
    }

    private static void dfs(int n, int[] queens, int row, List<List<String>> result){
        // base case
        if(row == n){
            List<String> list = new ArrayList<>();

            for(int i=0;i<n;i++){
                String str = "";
                for(int j=0;j<n;j++){
                    if (j != queens[i])
                        str += ".";
                    else
                        str += "Q";
                }
                list.add(str);
            }
            result.add(new ArrayList<>(list));
            return;
        }

        // 遍历所有可能的 column
        for(int i=0;i<n;i++){
            if(check(queens, row, i)){
                queens[row] = i;
                dfs(n, queens, row+1, result);
            }
        }
    }

    private static boolean check(int[] queens, int row, int col){
        for(int i=0;i<row;i++){
            if(queens[i] ==  col)
                return false;
            if(Math.abs(row-i) == Math.abs(col - queens[i]))      // diagonal
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        printAns(solveNQueens(5));
    }

    public static void printAns(List<List<String>> ans){
        for(List<String> sub_ans:ans){
            for(String row : sub_ans){
                System.out.println(row);
            }
            System.out.println(" ");
        }
    }
}
