package jianzhi;

/**
 * Created by Ellen on 2017/12/27.
 */
public class PrintMatrixClockWisely20 {
    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        printMatrixClockWisely(numbers);
    }
    public static void printMatrixClockWisely(int[][] numbers) {
        if (numbers==null) {
            return;
        }
        //开始打印的位置（0,0）（1,1）....
        int start = 0;
        int rows = numbers.length;
        int column = numbers[0].length;
        while (start*2<rows && start*2<column) {
            printMatrix(numbers, start);
            start++;
        }
    }
    public static void printMatrix(int[][] numbers, int start) {
        int rows = numbers.length;
        int column = numbers[0].length;
        //打印上面的一行
        for (int i=start; i<column-start; i++) {
            System.out.print(numbers[start][i] + " ");
        }
        //打印右边，高度至少为2
        if (rows-1-start>start) {
            for (int i=start+1; i<rows-start; i++) {
                System.out.print(numbers[i][column-1-start] + " ");
            }
        }

        //打印下面，高度至少为2且至少有两列
        if (rows-1-start>start && column-1-start>start) {
            for (int i = column-1-start-1; i>=start; i--) {
                System.out.print(numbers[rows-1-start][i] + " ");
            }
        }
        //打印左边，高度至少为3至少有两列
        if (rows-1-2*start>1 && column-1-start>start) {
            for (int i=rows-1-start-1; i>start; i--) {
                System.out.print(numbers[i][start] + " ");
            }
        }
    }
}
