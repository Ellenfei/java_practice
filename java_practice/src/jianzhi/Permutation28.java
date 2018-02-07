package jianzhi;

/**
 * Created by Ellen on 2018/1/4.
 */
public class Permutation28 {
    public static void main(String[] args) {
        char[] chars = {'a','b','c'};
        permutation(chars);
    }
    public static void permutation(char[] chars) {
        if (chars.length<1 || chars==null) {
            return;
        }
        permutation(chars, 0);
    }
    public static void permutation(char[] chars, int begin) {
        if (chars.length-1==begin) {
            System.out.print(new String(chars)+" ");
        } else {
            char temp;
            for (int i=begin; i<chars.length; i++) {
                temp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = temp;

                permutation(chars, begin+1);

                temp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = temp;
            }
        }
    }
}
