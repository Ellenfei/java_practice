package jianzhi;

/**
 * Created by Ellen on 2018/1/8.
 */
public class GetUglyNumber34 {
    public static void main(String[] args) {
        System.out.print(getUglyNumber(9));
    }
    public static int getUglyNumber(int index) {
        if (index<=0) {
            return 0;
        }
        int[] uglyNumber = new int[index];
        uglyNumber[0] = 1;
        int nextUglyNumber = 1;
        //об╠Й
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyNumber<index) {
            int min = Math.min(Math.min(uglyNumber[p2]*2, uglyNumber[p3]*3), uglyNumber[p5]*5);
            uglyNumber[nextUglyNumber] = min;
            while (uglyNumber[p2]*2<=uglyNumber[nextUglyNumber])
                p2++;
            while (uglyNumber[p3]*3<=uglyNumber[nextUglyNumber])
                p3++;
            while (uglyNumber[p5]*5<=uglyNumber[nextUglyNumber])
                p5++;
            nextUglyNumber++;
        }
        return uglyNumber[index-1];
    }
}
