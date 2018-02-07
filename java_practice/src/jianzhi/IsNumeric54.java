package jianzhi;

/**
 * Created by Ellen on 18-1-26.
 * 实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 */
public class IsNumeric54 {
    public static void main(String[] args) {
        String s1 = "+-123.55e-5";
        String s2 = "123e+55.5";
        System.out.println(isNumeric(s1));
    }
    public static boolean isNumeric(String str) {
        if (str==null) {
            return false;
        }
        int index = 0;
        if (str.charAt(index)=='-' || str.charAt(index)=='+') {
            index++;
        }
        //到达字符串末尾，返回false
        if (index>str.length()-1) {
            return false;
        }
        boolean numeric = true;
        index = scanDigits(str, index);
        //没有到达字符串的末尾
        if (index<str.length()) {
            //如果为‘.’，移到下一位
            if (str.charAt(index)=='.') {
                index++;
                index = scanDigits(str, index);
            }

            //到达字符串的末尾
            if (index>str.length()-1) {
                numeric = true;
            } else {
                numeric = isExponential(str, index);
            }
        }
        return numeric;
    }
    //找出非数字的位置
    public static int scanDigits(String str, int index) {
        while (index<str.length() && str.charAt(index)>='0' && str.charAt(index)<='9') {
            index++;
        }
        return index;
    }
    //判断是否为科学计数。如e5，E+5，e-5等
    public static boolean isExponential(String str, int index) {
        //不是科学计数
        if (index>str.length()-1 || (str.charAt(index)!='e' && str.charAt(index)!='E')) {
            return false;
        }
        //是科学计数
        index++;
        //到达字符串末尾，返回false
        if (index>str.length()-1) {
            return false;
        }
        //考虑e-5情况
        if (str.charAt(index)=='-' || str.charAt(index)=='+') {
            index++;
        }
        //到达字符串末尾，返回false
        if (index>str.length()-1) {
            return false;
        }
        index=scanDigits(str, index);
        //处理到了字符串的末尾
        return index==str.length();
    }
}
