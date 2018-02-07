package jianzhi;

/**
 * Created by Ellen on 2018/2/1.
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ���������һ��ʼ��ÿһ�������ھ����м������ҡ��ϡ����ƶ�һ��
 * ���һ��·�������˾����ĳһ����ô��·�������ٴν���ø��ӡ�
 */
public class MatrixHasPath66 {
    public static void main(String[] args) {

    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix==null || str==null || str.length>matrix.length || rows<1 || cols<1) {
            return false;
        }
        //��¼�����е�Ԫ���Ƿ���ʹ�
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
    //�ж�i��jλ�õ�Ԫ���Ƿ�Ϊstr[k]
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
