package jianzhi;

/**
 * Created by Ellen on 2018/1/4.
 */
public class MoreThanHalfNum29 {
    public static void main(String [] args) {
        int[] numbers = {1,2,2,2,3,3,3,3};
        System.out.print(moreThanHalf(numbers));
    }
    public static int moreThanHalfNum(int[] numbers) {
        if (numbers==null || numbers.length<1) {
            throw new RuntimeException("invalid input");
        }
        int index = patition(numbers, 0, numbers.length-1);
        //System.out.print(index+" ");
        int start = 0;
        int end = numbers.length-1;
        int mid = numbers.length>>1;
        while (index!=mid) {
            if (index>mid) {
                end = index-1;
                index = patition(numbers, start, end);
                //System.out.print(index+" ");
            } else {
                start = index+1;
                index = patition(numbers, start, end);
                //System.out.print(index+" ");
            }
        }
        int count = 0;
        for (int k=0; k<numbers.length; k++) {
            if (numbers[k]==numbers[index]) {
                count++;
            }
        }
//        System.out.print(count+" ");
        if (count*2<=numbers.length) {
            throw new RuntimeException("invalid input");
        }
        return numbers[index];
    }
    //快排核心
    public static int patition(int[] numbers, int start, int end) {
        int privot = numbers[start];
        int i = start, j = end;
        while (i<j) {
            while (i < j && numbers[j] >= privot) {
                j--;
            }
            numbers[i] = numbers[j];
            while (i < j && numbers[i] <= privot) {
                i++;
            }
            numbers[j] = numbers[i];
        }
        numbers[i] = privot;
        return i;
    }

    //方法2
    public static int moreThanHalf(int[] numbers) {
        if (numbers==null || numbers.length<1) {
            throw new RuntimeException("invalid input");
        }
        int count = 0;
        int result = numbers[0];
        for (int i=0; i<numbers.length; i++) {
            if (count==0) {
                result = numbers[i];
                count = 1;
            }else if (result==numbers[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
