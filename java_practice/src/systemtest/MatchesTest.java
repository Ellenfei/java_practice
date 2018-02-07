package systemtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ye on 2016/11/25.
 */
public class MatchesTest {
    public static void main (String [] args) {
        String [] mails = {"kongyeeku@163.com","kongyukee@gmail.com","ligang@crazyit.org","wawa@abc.xx"};
        String mailReg = "\\w{3,20}@\\w+\\.(com||org||cn||net||gov)";
        System.out.println("kongyeeku@163.com".matches("\\w{3,20}@\\w+\\.(com|org|cn|net|gov)"));
        Pattern mailPattern = Pattern.compile(mailReg);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = mailPattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            System.out.println(mail+(matcher.matches() ? "  yes" : "  no"));
        }
    }
}
