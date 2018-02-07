package algorithms4;

import java.security.Key;

/**
 * Created by Ellen on 2017/7/14.
 */
public class BST <Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int N;
        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }
    public int size(Node root) {
        if (root==null) return 0;
        return root.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }
    public Value get(Node root, Key key) {
        if (root==null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp<0) return get(root.left,key);
        else if (cmp>0) return get(root.right,key);
        return root.value;
    }
    public void put(Key key, Value value) {
        root = put(root,key,value);
    }
    public Node put(Node root, Key key, Value value) {
        if (root==null) {
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp<0) root.left = put(root.left,key,value);
        else if (cmp>0) root.right = put(root.right,key,value);
        else root.value = value;
        root.N = size(root.left)+size(root.right)+1;
        return root;
    }

}
