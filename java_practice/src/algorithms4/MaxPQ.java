package algorithms4;

/**
 * Created by Ellen on 2017/7/13.
 */
public class MaxPQ {
    private Integer[] heap;
    private int N=0;
    public MaxPQ(int maxN) {
        heap = new Integer[maxN+1];
    }
    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void insert(int val) {
        heap[++N] = val;
        swim(N);
    }

    public int delMax() {
        int max = heap[1];
        heap[1] = heap[N];
        heap[N] = Integer.parseInt(null);
        sink(1);
        return max;
    }

    public boolean less(Integer i, Integer j) {
        return heap[i].compareTo(heap[j])<0;
    }

    private void exch(int i, int j) {
        int temp;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void swim(int k) {
        while (k>1 && less(k/2, k)) {
            exch(k/2, k);
            k/=2;
        }
    }

    private void sink(int k) {
        while (2*k < N ) {
            int j = 2*k;
            if (j<N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(5);

    }

}
