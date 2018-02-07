package jianzhi;

/**
 * Created by Ellen on 2018/1/19.
 * 字符串转换为整数
 * 考虑全面
 */
public class StringToInt49 {
    public static void main(String[] args) {
        String num = "-123456";
        System.out.println(stringToInt(num));
        System.out.println(0x8000_0000);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
    public static int stringToInt(String num) {
        if (num==null || num.length()<1) {
            throw new RuntimeException("invalid input");
        }
        char first = num.charAt(0);
        if (first=='-') {
            return parseString(num, 1, false);
        } else if (first=='+'){
            return parseString(num, 1, true);
        } else if(isDigit(first)) {
            return parseString(num, 0, true);
        } else {
            throw new NumberFormatException(num);
        }
    }
    public static boolean isDigit(char ch) {
        return ch>='0' && ch<='9';
    }
    public static int parseString(String num, int index, boolean positive) {
        if (index>=num.length()) {
            throw new NumberFormatException(num);
        }
        int result;
        long temp = 0;
        while (index<num.length() && isDigit(num.charAt(index))) {
            temp = temp*10+(num.charAt(index)-'0');
            if (temp>Integer.MAX_VALUE) {
                //System.out.println(0x8000_0000L);
                throw new NumberFormatException(num);
            }
                index++;
        }
        if (positive) {
            if (temp>=0x8000_0000L) {
                throw new NumberFormatException(num);
            } else {
                result = (int)temp;
            }
        } else {
            if (temp==0x8000_0000L) {
                result = 0x8000_0000;
            } else {
                result = (int)-temp;
            }
        }
        return result;
    }
}
