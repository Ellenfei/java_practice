package systemtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ye on 2016/11/25.
 */
public class FindGroup {
    public static void main(String[] args) {
        String str = "������һ�����顷��������ϵ��13500006666"
                +"�����������绰15899992222";
        Matcher m = Pattern.compile("((13\\d) || (15\\d))\\d{11}").matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }

        String regStr = "Java is very easy~";
        Matcher m1 = Pattern.compile("\\w+").matcher(regStr);
        while (m1.find()) {
            System.out.println(m1.group()+" start��"+m1.start()+", end:"+m1.end());
        }
    }
}
