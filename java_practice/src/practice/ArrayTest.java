package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ellen on 2017/6/20.
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[] array = {"1","2"};
        listAll(Arrays.asList(array)," ");
    }
    public static void listAll (List candidate, String prefix) {
        //System.out.println(prefix);
        for (int i=0; i<candidate.size(); i++) {
            List temp = new LinkedList(candidate);
            //System.out.print(temp);
            listAll(temp, temp.remove(i) + prefix);
        }
        System.out.print(prefix);
    }
}
