package practice;

import java.util.*;

/**
 * Created by Ellen on 2017/6/20.
 * ��1��2��2��3��4��5���������֣���ӡ�����в�ͬ�����У��磺512234��412345�ȣ�Ҫ��'4'�����ڵ���λ��'3'��'5'����������
 */
public class SolutionArray {
    public static TreeSet ts = new TreeSet();
    public static void main(String[] args) {
        String[] s ={"2","2","3","4","5"};
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length; i++) {
            list.add(s[i]);
        }
        Pailie(list,sb);

        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public static void Pailie(List<String> list, StringBuilder sb) {
        if (list.size()==1) {
            sb.append(list.get(0));
            if (sb.indexOf("4")!=2 && !(sb.toString().contains("35")) && !(sb.toString().contains("53")))
                ts.add(sb.toString());
            sb.delete(sb.length()-1,sb.length());
            } else {
                for (int i=0; i<list.size(); i++) {
                    sb.append(list.get(i));
                    ArrayList<String> tmp = new ArrayList<>();
                    for (String a : list)
                        tmp.add(a);
                    tmp.remove(i);
                    Pailie(tmp,sb);
                    sb.delete(sb.length()-1,sb.length());
                }
            }
        }
}
