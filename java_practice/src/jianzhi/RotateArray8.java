package jianzhi;

/**
 * Created by Ellen on 2017/12/15.
 * ����һ����������������һ����ת�������ת�������СԪ�ء�
 * ��������{3, 4, 5, 1, 2��Ϊ��l ,2, 3, 4, 5}��һ����ת�����������СֵΪ
 * ���ö��ַ����������������
 */
public class RotateArray8 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,0,1};
        System.out.println(rotateMin(numbers));
    }

    public static int rotateMin (int[] numbers) {
        int start = 0;
        int end = numbers.length-1;
        int mid = 0;
        while(numbers[start]>=numbers[end]) {

            if (end-start==1) {
                return numbers[end];
            }
            mid = (start+end)/2;
            if (numbers[mid]>numbers[start]) {
                start = mid;
            } else if (numbers[mid]<numbers[end]){
                end = mid;
            }
            //���
            if (numbers[start]==numbers[end] && numbers[start]==numbers[mid]) {
                return minInorder(numbers, start, end);
            }
        }
        return numbers[mid];
    }

    public static int minInorder(int[] numbers, int start, int end) {
        int min = numbers[start];
        for (int i=start+1; i<=end; i++) {
            if (numbers[i]<min) {
                min = numbers[i];
            }
        }
        return min;
    }
}
