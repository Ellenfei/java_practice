package jianzhi;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/12/21.
 */
public class ReorderOddEven14 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        System.out.println(Arrays.toString(reorderOddEven(arr)));
    }
    //ʹ������ָ��
    public static int[] reorderOddEven(int[] arr) {
        if (arr==null || arr.length<2) {
            return arr;
        }
        //������
        int left = 0;
        //���ҵ���
        int right = arr.length-1;
        while (left<right) {
            while((arr[left] & 0x1) == 1) {
                left++;
            }
            while ((arr[right] & 0x01) == 0) {
                right--;
            }
            if (left<right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
    }
}
