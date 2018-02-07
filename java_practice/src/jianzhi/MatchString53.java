package jianzhi;

/**
 * Created by Ellen on 2018/1/25.
 * 1.第二个字符不是‘*’时。第一个字符匹配，成功，匹配剩余字符串和模式字符；失败，返回false；
 * 2.第二个字符是‘*’时。（1）如果模式字符串和匹配字符串中的 *第一个字符匹配，则匹配字符串向后移动一个字符，
 * 而模式字符串有两个选择，移动两个字符或保持不变。 （1）模式字符串向后移动两个字符，忽略了‘*’和前面的字符；
 */
public class MatchString53 {
    public static void main(String[] args) {
        String input = "aaa";
        String pattern = ".a*";
        System.out.println(match(input, pattern));
    }
    public static boolean match(String input, String pattern) {
        if (input==null || pattern==null) {
            return false;
        }
        return matchCore(input, 0, pattern, 0);
    }
    public static boolean matchCore(String input, int i, String pattern, int p) {
        //匹配串和模式串都到达末尾，匹配成功
        if (i==input.length() && p==pattern.length()) {
            return true;
        }
        //只有模式串到达末尾，匹配失败
        if (i!=input.length() && p==pattern.length()) {
            return false;
        }
        //第二个字符是’*‘
        if (p+1<pattern.length() && pattern.charAt(p+1)=='*') {
            if (i==input.length()) {
                return matchCore(input, i, pattern, p+2);
            }
            if (input.charAt(i) == pattern.charAt(p) || pattern.charAt(p)=='.') {
                return matchCore(input, i, pattern, p+2)
                        || matchCore(input, i+1, pattern, p+2)
                        || matchCore(input, i+1, pattern, p);

            } else {
                return matchCore(input, i, pattern, p+2);
            }
        } else {
            if (input.charAt(i)==pattern.charAt(p) || pattern.charAt(p)=='.') {
                return matchCore(input, i+1, pattern, p+1);
            } else {
                return false;
            }
        }
    }
}
