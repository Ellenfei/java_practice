package jianzhi;

/**
 * Created by Ellen on 2018/1/25.
 * 1.�ڶ����ַ����ǡ�*��ʱ����һ���ַ�ƥ�䣬�ɹ���ƥ��ʣ���ַ�����ģʽ�ַ���ʧ�ܣ�����false��
 * 2.�ڶ����ַ��ǡ�*��ʱ����1�����ģʽ�ַ�����ƥ���ַ����е� *��һ���ַ�ƥ�䣬��ƥ���ַ�������ƶ�һ���ַ���
 * ��ģʽ�ַ���������ѡ���ƶ������ַ��򱣳ֲ��䡣 ��1��ģʽ�ַ�������ƶ������ַ��������ˡ�*����ǰ����ַ���
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
        //ƥ�䴮��ģʽ��������ĩβ��ƥ��ɹ�
        if (i==input.length() && p==pattern.length()) {
            return true;
        }
        //ֻ��ģʽ������ĩβ��ƥ��ʧ��
        if (i!=input.length() && p==pattern.length()) {
            return false;
        }
        //�ڶ����ַ��ǡ�*��
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
