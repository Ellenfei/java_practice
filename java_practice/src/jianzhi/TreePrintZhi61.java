package jianzhi;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ellen on 2018/1/31.
 * 之字打印二叉树
 */
public class TreePrintZhi61 {
    public static void main(String[] args) {
        MyBinaryTree root = new MyBinaryTree(1);
        root.left = new MyBinaryTree(2);
        root.right = new MyBinaryTree(3);
        root.left.left = new MyBinaryTree(4);
        root.left.right = new MyBinaryTree(5);
        System.out.println(printTree(root));
    }
    //之字打印二叉树
    public static List<ArrayList<Integer>> printTree(MyBinaryTree root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        //存放奇数层的节点
        Stack<MyBinaryTree> s1 = new Stack<>();
        s1.push(root);
        //存放偶数层节点
        Stack<MyBinaryTree> s2 = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                ArrayList<Integer> l1 = new ArrayList<>();
                while (!s1.isEmpty()) {
                    MyBinaryTree node = s1.pop();
                    l1.add(node.val);
                    //偶数层是从右到左打印，从左到右入栈
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                    if (node.right != null) {
                        s2.push(node.right);
                    }
                }
                result.add(l1);
            } else {
                ArrayList<Integer> l2 = new ArrayList<>();
                while (!s2.isEmpty()) {
                    MyBinaryTree node = s2.pop();
                    l2.add(node.val);
                    //奇数层从左到右打印，从右到左入栈
                    if (node.right!=null) {
                        s1.push(node.right);
                    }
                    if (node.left!=null) {
                        s1.push(node.left);
                    }
                }
                result.add(l2);
            }
        }
        return result;
    }
}
