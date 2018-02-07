package systemtest;

/**
 * Created by ye on 2016/11/24.
 */
public class StringBuilderTest {
    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("java");
        sb.insert(0, "hello ");
        System.out.println(sb);
        sb.replace(5, 6, ",");
        System.out.println(sb);
        sb.delete(5, 6);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }
}
