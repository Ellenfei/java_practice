package jianzhi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ellen on 18-1-26.
 * ֻ����һ�ε��ַ�
 */
public class CharStatistics55 {
    public static void main(String[] args) {
        System.out.println('\0');
        System.out.println(getAppearOnceCharacter("google"));
    }

    public static char getAppearOnceCharacter(String str) {
        if (str==null || str.length()<1) {
            throw new RuntimeException("invalid input!");
        }
        //hashmap����֤����
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), -2);
            } else {
                map.put(str.charAt(i), i);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        //����
        //��¼ֻ����һ�ε��ַ�������
        int index = Integer.MAX_VALUE;
        //ֻ����һ�ε��ַ�
        char result = '\0';
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue()>=0 && entry.getValue()<index) {
                index = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
