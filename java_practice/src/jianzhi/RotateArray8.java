package jianzhi;

/**
 * Created by Ellen on 2017/12/15.
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3, 4, 5, 1, 2｝为｛l ,2, 3, 4, 5}的一个旋转，该数组的最小值为
 * 利用二分法（考虑特殊情况）
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
            //相等
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
