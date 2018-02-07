package jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ellen on 2017/12/29.
 */
public class PrintFromToBottom23 {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.left.left = new MyTreeNode(4);
        root.right = new MyTreeNode(3);
        printFromToBottom(root);
    }
    public static void printFromToBottom(MyTreeNode root) {
        if (root==null) {
            return;
        }
        // 利用队列存储节点
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                MyTreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }

            }
            System.out.println();
        }
    }
}
