package question01_50;

import java.util.HashSet;

public class Q37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == '.') {
                    for (char n = '1'; n <= '9'; n++) {
                        if (possible(board, y, x, n)) {
                            board[y][x] = n;
                            if(solve(board))
                                return true;
                            else
                                board[y][x] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean possible(char[][] board, int y, int x, char n){
        for (int i = 0; i < 9; i++) {
            if(board[y][i] == n)
                return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][x] == n)
                return false;
        }
        int x0 = (x/3) * 3;
        int y0 = (y/3) * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[y0+i][x0+j] == n)
                    return false;
            }
        }
        return true;
    }
}
