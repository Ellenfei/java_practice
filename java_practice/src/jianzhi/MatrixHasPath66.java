package jianzhi;

/**
 * Created by Ellen on 2018/2/1.
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中任意一格开始，每一步可以在矩阵中间向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 */
public class MatrixHasPath66 {
    public static void main(String[] args) {

    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix==null || str==null || str.length>matrix.length || rows<1 || cols<1) {
            return false;
        }
        //记录矩阵中的元素是否访问过
        int[] flag = new int[matrix.length];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }
    //判断i，j位置的元素是否为str[k]
    public static boolean helper(char[] matrix, int rows, int cols, int i, int j,
                                 char[] str, int k, int[] flag) {
        int index = i*cols+j;
        if (i<1 || i>rows-1 || j<1 || j>cols-1 || matrix[index]!=str[k] || flag[index]==1) {
            return false;
        }
        if (k==str.length-1) {
            return true;
        }
        flag[index] = 1;
        if (helper(matrix, rows, cols, i-1, j, str, k+1, flag) ||
                helper(matrix, rows, cols, i+1, j, str, k+1, flag) ||
                helper(matrix, rows, cols, i, j-1, str, k+1, flag) ||
                helper(matrix, rows, cols, i, j+1, str, k+1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }
}
