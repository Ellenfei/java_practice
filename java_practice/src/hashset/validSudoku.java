package hashset;

import java.util.HashSet;

/**
 * Created by ye on 2017/1/19.
 */
public class validSudoku {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if (board[i][j]!='.' && !columns.add(board[i][j]))
                    return false;
                if (board[i][j]!='.' && !columns.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
}
