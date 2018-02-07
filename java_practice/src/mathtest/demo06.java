package mathtest;

/**
 * Created by ye on 2017/3/20.
 */
public class demo06 {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        tell(arr);
    }

    public static <T>void  tell(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }

}
