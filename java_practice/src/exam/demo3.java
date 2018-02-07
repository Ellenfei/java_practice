package exam;


import java.util.HashMap;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/4/6.
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String jiamiStr = in.nextLine();
        String originStr = in.nextLine();
        System.out.print(isOrigin(originStr,jiamiStr));
    }
    public static boolean isOrigin(String originStr, String jiamiStr) {
        if (originStr.length() != jiamiStr.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map1 = new HashMap<>();
        for (int i=0; i<originStr.length(); i++) {
            if (originStr.charAt(i)=='Z' && map.get(originStr.charAt(i))==0)
                map.put('A',0);
            else if (map.get(originStr.charAt(i))==0)
                map.put((char)(originStr.charAt(i)+1), map.get(originStr.charAt(i))+1);
        }

        for (int i=0; i<jiamiStr.length(); i++) {
            if (map1.get(jiamiStr.charAt(i))==0)
                map1.put(jiamiStr.charAt(i),0);
            else
                map1.put((char)(jiamiStr.charAt(i)+1), map1.get(jiamiStr.charAt(i))+1);
        }

        if (map.size() != map1.size()) return false;

        for (int i=0; i<originStr.length(); i++) {
            if (map1.containsKey(map.get(originStr.charAt(i))) &&
                    map1.get(originStr.charAt(i))==map.get(originStr.charAt(i)))
                continue;
            else
                return false;
        }
        return true;
    }



}
