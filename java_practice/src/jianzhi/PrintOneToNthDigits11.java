package jianzhi;

/**
 * Created by Ellen on 2017/12/19.
 */
public class PrintOneToNthDigits11 {
    public static void main(String[] args) {
        printOneToNthDigits(3);
    }
    public static void printOneToNthDigits(int n) {
        if (n<1) {
            throw new RuntimeException("Invalid input!");
        }
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }
    public static void printOneToNthDigits(int index, int[] arr) {
        if (index==arr.length) {
            printNumber(arr);
        }else {
            //�ݹ�
            for (int i=0; i<=9; i++) {
                arr[index] = i;
                printOneToNthDigits(index+1, arr);
            }
        }
    }
    public static void printNumber(int[] arr) {
        int index = 0;
        //��һ����0���ִ�ӡ
        while (index<arr.length && arr[index]==0) {
            index++;
        }
        for (int i=index; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
        //���д�ӡ
        if (index<arr.length) {
            System.out.println();
        }
    }
}
