package jianzhi;

import java.util.*;

/**
 * Created by Ellen on 2018/1/19.
 */
public class TreeInorder {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.right = new MyTreeNode(3);
        root.left.left = new MyTreeNode(4);
        System.out.println(inorderTravel(root));
        System.out.println(inorder(root));
    }
    //ÖÐÐò±éÀú
    public static ArrayList<Integer> inorderTravel(MyTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        MyTreeNode curNode = root;
        java.util.Stack<MyTreeNode> stack = new java.util.Stack<>();
        //stack.push(curNode);
        while (curNode!=null || !stack.isEmpty()) {
           // curNode = stack.pop();
            if (curNode!=null) {
                stack.push(curNode);
                curNode = curNode.left;

            } else {
                curNode = stack.pop();
                res.add(curNode.val);
                curNode = curNode.right;
            }

        }
        return res;
    }

    //µÝ¹é
    public static ArrayList<Integer> inorder(MyTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        inorderRecursion(root, res);
        return res;
    }
    public static void inorderRecursion(MyTreeNode root, ArrayList<Integer> list) {
        if (root==null) {
            return;
        }
        inorderRecursion(root.left, list);
        list.add(root.val);
        inorderRecursion(root.right, list);
    }
}
