package jianzhi;

/**
 * Created by Ellen on 2018/1/18.
 * ���üӼ��˳�ʵ�ּӷ�����
 */
public class Add47 {
    public static void main(String[] args) {
        System.out.println(add(3, 5));
    }
    public static int add(int x, int y) {
        int sum = 0;
        int carry = 0;
        while (y!=0) {
            sum = x^y;
            carry = (x&y)<<1;
            x = sum;
            y = carry;
        }
        return sum;
    }
}
