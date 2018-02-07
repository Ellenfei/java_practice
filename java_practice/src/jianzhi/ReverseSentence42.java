package jianzhi;

/**
 * Created by Ellen on 2018/1/15.
 */
public class ReverseSentence42 {
    public static void main(String[] args) {
        String s = "I am a student.";
//        reverseSentence(s);
        System.out.println(reverseSentence(s));
        System.out.println(leftRotateString(s, 3));
    }
    public static String reverseSentence(String s) {
        if (s==null || s.length()<1) {
            return null;
        }
        char[] ch = s.toCharArray();
        reverse(ch, 0, s.length() - 1);
//        System.out.println(new String(ch));
        int start = 0;
        int end = 0;
        while (end<=ch.length) {
            if (ch[start]==' ') {
                start++;
                end++;
//                end++;
            } else if ( end==ch.length || ch[end]==' ') {
                reverse(ch, start, end-1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
//        System.out.print(new String(ch));
        return new String(ch);

    }
    public static void reverse(char[] ch, int start, int end) {
        while (start<end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
    //翻转字符串的两部分
    public static String leftRotateString(String s, int n) {
        if (s==null || s.length()<1 || n>=s.length()) {
            throw new RuntimeException("invalid input!");
        }

        char[] ch = s.toCharArray();
        int firstStart = 0;
        int firstEnd = n-1;
        int secondStart = n;
        int secondEnd = ch.length-1;
        //分别翻转
        reverse(ch, firstStart, firstEnd);
        reverse(ch, secondStart, secondEnd);
        reverse(ch, firstStart, secondEnd);
        return new String(ch);
    }
}
