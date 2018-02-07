package jianzhi;

/**
 * Created by Ellen on 2018/1/5.
 */
public class GetLeastNumbers30 {
    public static void main(String[] args) {
        int[] input = {3,4,2,5,1,6};
        int[] out = new int[2];
//        getLeastNumbers(input, out);
        minHeapKNum(input, out.length);
        for (int i=input.length-1; i>input.length-out.length-1; i--) {
            System.out.print(input[i]+" ");
        }
    }

    //最小堆---o(nlog(k))
    //得到最小的k个数
    public static void minHeapKNum(int[] input, int k) {
        if (input==null || input.length<1 || k<1 || k>input.length) {
            return;
        }
        int len = input.length;
        //建立最小堆
        for (int i=len/2; i>=0; i--) {
            adjustHeap(input, i, len-1);
        }
        //进行堆排序
        for (int i=len-1; i>=len-k; i--) {
            int temp = input[i];
            input[i] = input[0];
            input[0] = temp;
            adjustHeap(input, 0, i-1);
        }
    }

    public static void adjustHeap(int[] input, int start, int end) {
        int temp = input[start];
        int index = 2*start+1;
        while (index<=end) {
            if (index+1<=end && input[index]>input[index+1]) {
                index = index+1;
            }
            //最小节点向上移动，替换掉父节点
            if (index<=end && input[index]<temp) {
                input[start] = input[index];
                //input[index]
                start = index;
                index = 2*index+1;
            } else {
                break;
            }
        }
        input[start] = temp;
    }

    //o(n)
    public static void getLeastNumbers(int[] input, int[] output) {
        if (input==null || output==null || output.length>input.length) {
            throw new RuntimeException("invalid input");
        }
        int len = input.length;
        int start = 0, end = len-1;
        int k = output.length-1;
        int index = partition(input, 0, end);
        while (index!=k) {
            if (index>k) {
                end = index-1;
                partition(input, start, end);
            } else {
                start = index+1;
                partition(input, start, end);
            }
        }
        System.arraycopy(input, 0, output, 0, k+1);
    }
    //快排核心
    public static int partition(int[] input, int start, int end) {
        int temp = input[start];
        while (start<end) {
            while (start<end && input[end]>=temp) {
                end--;
            }
            input[start] = input[end];
            while (start<end && input[start]<=temp) {
                start++;
            }
            input[end] = input[start];
        }
        input[start] = temp;
        return start;
    }

}
