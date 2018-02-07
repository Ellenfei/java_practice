package jianzhi;

/**
 * Created by Ellen on 18-1-26.
 * ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С����
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
        //�����ַ���ĩβ������false
        if (index>str.length()-1) {
            return false;
        }
        boolean numeric = true;
        index = scanDigits(str, index);
        //û�е����ַ�����ĩβ
        if (index<str.length()) {
            //���Ϊ��.�����Ƶ���һλ
            if (str.charAt(index)=='.') {
                index++;
                index = scanDigits(str, index);
            }

            //�����ַ�����ĩβ
            if (index>str.length()-1) {
                numeric = true;
            } else {
                numeric = isExponential(str, index);
            }
        }
        return numeric;
    }
    //�ҳ������ֵ�λ��
    public static int scanDigits(String str, int index) {
        while (index<str.length() && str.charAt(index)>='0' && str.charAt(index)<='9') {
            index++;
        }
        return index;
    }
    //�ж��Ƿ�Ϊ��ѧ��������e5��E+5��e-5��
    public static boolean isExponential(String str, int index) {
        //���ǿ�ѧ����
        if (index>str.length()-1 || (str.charAt(index)!='e' && str.charAt(index)!='E')) {
            return false;
        }
        //�ǿ�ѧ����
        index++;
        //�����ַ���ĩβ������false
        if (index>str.length()-1) {
            return false;
        }
        //����e-5���
        if (str.charAt(index)=='-' || str.charAt(index)=='+') {
            index++;
        }
        //�����ַ���ĩβ������false
        if (index>str.length()-1) {
            return false;
        }
        index=scanDigits(str, index);
        //�������ַ�����ĩβ
        return index==str.length();
    }
}
