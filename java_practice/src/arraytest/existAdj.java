package arraytest;

/**
 * Created by ye on 2017/3/24.
 * �ݹ鷨
 */
public class existAdj {
    public static void main(String[] args) {
        /*char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };*/
        char[][] board = {{'A','A'}};
        String word = "AAA";
        System.out.print(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length==0 || board[0].length==0) return false;
        char[] wordC = word.toCharArray();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (exist(board,i,j,wordC,0)) return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int row, int column, char[] word, int k) {
        if (k==word.length) return true;
        if (row<0 || column<0 || row==board.length || column==board[0].length) return false;
        if (board[row][column]!=word[k]) return false;
        board[row][column] = '*';
        boolean exist = exist(board,row,column+1,word,k+1) ||
                exist(board,row,column-1,word,k+1) ||
                exist(board,row+1,column,word,k+1)||
                exist(board,row-1,column,word,k+1);
        board[row][column] = word[k];
        return exist;
    }

}
