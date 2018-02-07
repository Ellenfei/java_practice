package algorithms4;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/10/17.
 * 低位优先(基数排序)---LSD
 */
public class LSD {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        String[] s = new String[5];
        for (int i=0; i<5; i++) {
            s[i] = in.nextLine();
        }*/
        String[] a = {"4PGC938", "2IYE230", "3CI0720", "1ICK750", "10HV845"};

        sort(a, 7);
    }
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int i=W-1; i>=0; i--) {
            int[] count = new int[R+1];
            //计算出现的频率
            for (int j=0; j<N; j++) {
                count[a[j].charAt(i)+1]++;
            }
            //将频率转换为索引
            for (int r=0; r<R; r++) {
                count[r+1] += count[r];
            }

            for (int j=0; j<N; j++) {
                aux[count[a[j].charAt(i)]++] = a[j];
            }

            for (int j=0; j<N; j++) {
                a[j] = aux[j];
            }
        }
        for (int i=0; i<N; i++)
            System.out.println(a[i]);
    }
}
