package quesetion51_100;

public class Q59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        // 边界问题
        if(n == 0)  return new int[][]{};
        if(n == 1)  return new int[][]{{1}};

        int[][] res = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[i][j] = -1;
            }
        }

        int count = 1;
        int turn = 0;
        int i = 0, j = 0;

        while(count <= n * n){
            res[i][j] = count;
            if(turn == 0){          // right
                if(j+1 < n && res[i][j+1] == -1){
                    j++;
                }else{
                    turn = 1;
                    i++;
                }
            }else if(turn == 1){    // downward
                if(i+1 < n && res[i+1][j] == -1){
                    i++;
                }else{
                    turn = 2;
                    j--;
                }
            }else if(turn == 2){    // left
                if(j-1 > -1 && res[i][j-1] == -1){
                    j--;
                }else{
                    turn = 3;
                    i--;
                }
            }else{                  // upward
                if(i-1 > -1 && res[i-1][j] == -1){
                    i--;
                }else{
                    turn = 0;
                    j++;
                }
            }
            count++;
        }

        return res;
    }
}
