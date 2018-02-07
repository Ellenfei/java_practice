package jianzhi;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Ellen on 2018/1/9.
 */
public class FirstNotRepeatingChar35 {
    public static void main(String[] args) {
        String s = "eeeacba";
        System.out.print(firstNotRepeatingChar(s));
    }
    public static char firstNotRepeatingChar(String s) {
        if (s==null || s.length()<0) {
            throw new RuntimeException("invalid input");
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
//        for (Character key : map.keySet()) {
//            if (map.get(key)==1) {
//                return key;
//            } else {
//                continue;
//            }
//        }
        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i))==1) {
                return s.charAt(i);
            } else {
                continue;
            }
        }
        //return '\0';
        throw new RuntimeException("wu");
    }
}
