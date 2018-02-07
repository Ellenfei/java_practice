package greedy;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/3/30.
 * ���ȶ�g��s�������������ǰ���ɴ�С���㺢�ӵ�����У�g��s�����±���ƣ�����ֻ�ƶ�s������
 */
public class contentChild {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.print(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        int i=0,j=0;
        while (i<g.length && j<s.length) {
            if (g[i] > s[j]) {
                j++;
            } else {
                i++;
                j++;
                res++;
            }
        }
        return res;
    }
}
