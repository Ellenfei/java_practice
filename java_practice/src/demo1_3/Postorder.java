package demo1_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ellen on 2017/12/8.
 */
public class Postorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right  = new TreeNode(7);

        System.out.print(postorder(root));
    }
    public static List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root; //当前访问的节点
        TreeNode lastVisitedNode = null;  //上次访问的节点
        //把当前节点移到左子树最左位置
        while(curNode!=null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
        //一个根节点被访问的前提是无right或right已经visited
        while(!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode.right!=null && curNode.right!=lastVisitedNode) {
                stack.push(curNode);
                curNode = curNode.right;
                while (curNode!=null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                list.add(curNode.val);
                lastVisitedNode = curNode;
            }
        }
        return list;
    }
}
