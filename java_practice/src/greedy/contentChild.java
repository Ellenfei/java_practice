package greedy;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/3/30.
 * 首先对g，s进行排序，如果当前饼干大小满足孩子的满足感，g，s索引下标后移，否则只移动s的索引
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
