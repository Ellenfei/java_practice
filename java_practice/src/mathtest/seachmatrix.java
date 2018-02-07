package mathtest;

/**
 * Created by ye on 2017/3/15.
 */
public class seachmatrix {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //¶þ·Ö·¨
        int n = matrix.length;
        int m = matrix[0].length;
        int l=0, r=n*m-1;
        while (l < r) {
            int mid = (l+r)>>1;
            if (matrix[mid/m][mid%m] < target)
                l = mid+1;
            else
                r = mid;
        }

        return matrix[r/m][r%m] == target;
    }
}
