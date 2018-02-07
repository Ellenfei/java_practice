package algorithms4;

/**
 * Created by Ellen on 2017/7/14.
 */
public class BinarySeachST <Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public BinarySeachST(int capacity) {
        keys = (Key[])new Comparable[capacity];
        values = (Value[])new Comparable[capacity];
    }
    public int size() {
        return N;
    }
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i<N && key.compareTo(keys[i])==0) return values[i];
        return null;
    }
    public void put(Key key, Value value) {
        int i=rank(key);
        if (i<N && key.compareTo(keys[i])==0) {
            values[i] = value;
            return;
        }
        for (int j=N; j>i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public int rank(Key key) {  //二分查找法
        int l=0, h=N-1;
        while (l<=h) {
            int mid = l + (h-l)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp<0) h = mid-1;
            else if (cmp>0) l = mid+1;
            else return mid;
        }
        return l;
    }
}
