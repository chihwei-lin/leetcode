package quesetion51_100;

import java.util.ArrayList;
import java.util.List;

public class Q54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // 边界问题
        if(matrix == null || matrix.length == 0)    return result;

        int m = matrix.length, n = matrix[0].length;
        int count = m * n;
        boolean[][] seen = new boolean[m][n];
        int i=0, j=0, turn=0;

        while(count > 0){
            if(!seen[i][j]){
                result.add(matrix[i][j]);
                seen[i][j] = true;
                if(turn == 0){
                    if(j+1 == n || seen[i][j+1]){
                        turn = 1;
                        i++;
                    }else
                        j++;
                }else if(turn == 1){
                    if(i+1 == m || seen[i+1][j]){
                        turn = 2;
                        j--;
                    }else
                        i++;
                }else if(turn == 2){
                    if(j-1 == -1 || seen[i][j-1]){
                        turn = 3;
                        i--;
                    }else
                        j--;
                }else{
                    if(seen[i-1][j]){
                        turn = 0;
                        j++;
                    }else
                        i--;
                }
            }
            count--;
        }

        return result;
    }
}
