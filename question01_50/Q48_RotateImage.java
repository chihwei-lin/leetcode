package question01_50;

public class Q48_RotateImage {
    public void rotate(int[][] matrix) {
        // 边界问题
        if(matrix == null)  return;

        int n = matrix.length;
        // 上下倒反
        for(int i=0;i<n/2;i++){
            int swap_row = n-i-1;
            for(int j=0;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[swap_row][j];
                matrix[swap_row][j] = tmp;
            }
        }

        // 对称变换
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
