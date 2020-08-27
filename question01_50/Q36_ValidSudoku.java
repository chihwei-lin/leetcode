package question01_50;

import java.util.HashSet;

public class Q36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                if(c != '.'){
                    // row, column, sub box
                    boolean row = set.add("row " + i + " : " + c);
                    boolean col = set.add("column " + j + " : " + c);
                    boolean box = set.add("subbox " + i/3 + "-" + j/3 + " : " + c);

                    if(!row || !col || !box)
                        return false;
                }
            }
        }

        return  true;
    }
}
