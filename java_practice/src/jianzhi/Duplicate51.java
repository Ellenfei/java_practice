package jianzhi;

/**
 * Created by Ellen on 2018/1/23.
 */
public class Duplicate51 {
    public static void main(String[] args) {
        int[] number = {2,1,3,1,4};
        System.out.println(duplicate(number));
    }
    public static int duplicate(int[] number) {
        if (number==null || number.length<1) {
            return -1;
        }
        //判断输入是否在0-n-1之间
        for (int i : number) {
            if (i<0 || i>number.length-1) {
                return -1;
            }
        }
        //交换数字
        for (int i=0; i<number.length; i++) {
            while (number[i]!=i) {
                if (number[i]==number[number[i]]) {
                    return number[i];
                } else {
                    swap(number, i, number[i]);
                }
            }
        }
        return -1;
    }

    //交换函数
    public static void swap(int[] number, int num1, int num2) {
        int temp = number[num1];
        number[num1] = number[num2];
        number[num2] = temp;
    }
}
