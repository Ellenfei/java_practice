package algorithms4;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/7/12.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i=0; i<N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p)==find(q);
    }

    public int find (int p) {
        while (p!=id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID==qID) return;
        if (sz[pID]<sz[qID]) {
            id[pID] = qID;
            sz[qID] += sz[pID];
        } else {
            id[qID] = pID;
            sz[pID] += sz[qID];
        }
        count--;
    }
    public static void main() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

    }

}
