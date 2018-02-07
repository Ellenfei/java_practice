package jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2018/1/18.
 */
public class Josephus2_45 {
    public static void main(String[] args) {
        System.out.print(lastRemaining(5,3));
    }
    //����ɾ����0---n-1�еĵ�m������
    public static int lastRemaining(int n, int m) {
        if (n<1 || m<1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(i);
        }
        //ɾ��Ԫ�ص��±�
        int index = 0;
        //��ʼ������λ��
        int start = 0;
        while (list.size()>1) {
            for (int i=1; i<m; i++) {
                index = (index+1)%list.size();
            }
//            System.out.print(list.get(index)+" ");
            list.remove(index);
        }
        return list.get(0);
    }
}
