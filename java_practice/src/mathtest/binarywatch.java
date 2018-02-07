package mathtest;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by ye on 2017/3/20.
 */
public class binarywatch {
    public static void main(String[] args) {
        System.out.print(readBinaryWatch(1));
    }
    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int h=0; h<12; h++) {
            for (int m=0; m<60; m++) {
                if (Integer.bitCount(h)+Integer.bitCount(m)==num) {
                    //%02d代表以固定的两位显示十进制数，不足的前面补0。而%2d前面没有指定0
                    list.add(String.format("%d:%02d",h,m));
                }
            }
        }
        return list;
    }
}
