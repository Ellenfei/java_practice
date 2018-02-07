package jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2018/1/22.
 */
public class GetNodePath50 {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.right = new MyTreeNode(3);
        root.left.left = new MyTreeNode(4);
        findPath(root, 4);
    }
    public static void findPath(MyTreeNode root, int expectedSum) {
        List<Integer> res = new ArrayList<>();
        if (root==null) {
            return;
        }
        findPath(root, 0, expectedSum, res);
    }
    public static void findPath(MyTreeNode root, int curSum, int expectedSum, List<Integer> result) {
        if (root!=null) {
            result.add(root.val);
            curSum += root.val;
            if (curSum<expectedSum) {
                findPath(root.left, curSum, expectedSum, result);
                findPath(root.right, curSum, expectedSum, result);
            } else if (curSum==expectedSum) {
                if (root.left==null && root.right==null) {
                    System.out.println(result);
                    return;
                }
            }
            result.remove(result.size()-1);
        }
    }

}
