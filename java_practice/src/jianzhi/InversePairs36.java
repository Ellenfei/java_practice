package jianzhi;

/**
 * Created by Ellen on 2018/1/10.
 */
public class InversePairs36 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15
    }
    public static int inversePairs(int[] data) {
        if(data==null || data.length<1) {
            throw new RuntimeException("invalid input");
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return inversePairsCore(data, copy, 0, data.length-1);
    }
    public static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start==end) {
            copy[start] = data[start];
            return 0;
        }

        //需要排序的数组长度
        int len = (end-start)/2;

        int left = inversePairsCore(data, copy, start, start+len);
        int right = inversePairsCore(data, copy, start+len+1, end);
        //两个数组的末尾
        int i = start+len;
        int j = end;
        //复制数组下标
        int indexCopy = end;
        //逆序对数目
        int count = 0;
        while (i>=start && j>=start+len+1) {
            if (data[i]>data[j]) {
                copy[indexCopy--] = data[i--];
                count += j-start-len;
                //i--;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        while (i>=start) {
            copy[indexCopy--] = data[i--];
        }
        while (j>=start+len+1) {
            copy[indexCopy--] = data[j--];
        }
        return count+left+right;
    }
}
