package algorithms4;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/7/13.
 */
class IndexMinPQ<T extends Comparable<T>> {
    private int N;
    private int[] pq;//保存索引
    private int[] qp;//逆序 qp[i]的值是i在pq[]中的位置（即索引j，pq[j]=i）
    private T[] keys;//保存值

    public IndexMinPQ(int maxN) {
        pq = new int[maxN+1];
        qp = new int[maxN+1];
        keys = (T[])new Comparable[maxN+1];
        for (int i=0; i<maxN+1; i++)
            qp[i] = -1;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public boolean contains(int k) {
        return qp[k]==-1;
    }

    public void insert(int k, T key) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public T min() {
        return keys[pq[1]];
    }

    public int delMin() {
        int index = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N+1]]= null;
        qp[pq[N+1]] = -1;
        return index;
    }

    private void change(int k, T key) {
        keys[k] = key;
        //swim();
    }

    private void swim(int k) {
        while (k/2>1 && less(k/2,k)) {
            exch(k/2,k);
            k /= 2;
        }
    }
    private void sink(int k) {
        while (k*2<N) {
            int j=k*2;
            if (j<N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }
    private boolean less(int i, int j) {
        return pq[i]<pq[j];
    }
    private void exch(int i, int j) {
        int temp;
        temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

}

public class Multiway {
    public static void merge() {
        final int N = 3;
        Scanner in = new Scanner(System.in);
        String[] str = new String[N];
        for (int i=0; i<N; i++) {
            str[i] = in.next();
        }
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);
        for (int i=1; i<N+1; i++) {
            pq.insert(i,str[i-1]);
        }
        System.out.println(pq.toString());
        while (!pq.isEmpty()) {
            System.out.println(pq.min());
            int i = pq.delMin();
            /*if (i<3)
                pq.insert(i,str[i]);*/
        }
       // for ()
    }
    public static void main(String[] args) {
        merge();
    }
}
