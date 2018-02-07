package jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ellen on 2018/1/31.
 * 从上到下，左到右打印二叉树
 */
public class TreePrint60 {
    public static void main(String[] args) {
        MyBinaryTree root = new MyBinaryTree(1);
        root.left = new MyBinaryTree(2);
        root.right = new MyBinaryTree(3);
        root.left.left = new MyBinaryTree(4);
        printTree(root);
    }
    //打印二叉树
    public static void printTree(MyBinaryTree root) {
        if (root==null) {
            return;
        }
        Queue<MyBinaryTree> queue = new LinkedList<>();
        queue.offer(root);
       // int
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                MyBinaryTree node = queue.poll();
                System.out.print(node.val+" ");
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
}
