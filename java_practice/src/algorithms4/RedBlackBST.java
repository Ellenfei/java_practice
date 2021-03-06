package algorithms4;

/**
 * Created by Ellen on 2017/8/3.
 */
public class RedBlackBST <Key extends Comparable<Key>,Value>{
    private Node root;
    private static final boolean RED  = true;
    private static final boolean BLACK  = false;
    private class Node {
        Key key;
        Value value;
        Node left,right;
        int N;
        boolean color;
        Node(Key key,Value val, int N, boolean color) {
            this.key=key;
            this.value=val;
            this.N=N;
            this.color=color;
        }
    }

    private boolean isRed(Node x) {
        if (x==null) return false;
        return x.color==RED;
    }

    private int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x==null) return 0;
        else return x.N;
    }

    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+size(h.left)+size(h.right);
        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+size(h.left)+size(h.right);
        return x;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value val) {
        root = put(root,key,val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val) {
        if (h==null) return new Node(key,val,1,BLACK);
        int cmp = key.compareTo(h.key);
        if (cmp<0) h.left = put(h.left, key, val);
        else if (cmp>0) h.right = put(h.right, key, val);
        else h.value = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.right) && isRed(h.left))  flipColors(h);

        h.N =  1+size(h.left)+size(h.right);
        return h;
    }
}
