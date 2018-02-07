package practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/20.
 */
public class stringTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please input string:");
        String line = in.next();
        char[] ch = line.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<ch.length;i++) {
            if (map.containsKey(ch[i]))
                map.put(ch[i],map.get(ch[i])+1);
            else
                map.put(ch[i],1);
        }
        int max = 1;
        for (int i=0; i<ch.length; i++) {
            max = Math.max(max, map.get(ch[i]));
        }
        System.out.println(max);
    }

}
