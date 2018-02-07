package jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2018/1/2.
 */
public class FindPath25 {
    public static void main(String[] args) {
        MyTreeNode root1 = new MyTreeNode(1);
        root1.left = new MyTreeNode(2);
        root1.right = new MyTreeNode(3);
        root1.left.left = new MyTreeNode(4);
        root1.left.right = new MyTreeNode(5);
        findPath(root1, 6);
    }

    public static void findPath(MyTreeNode root, int expectedSum) {
        //´æ·Å½á¹û
        ArrayList<Integer> list  = new ArrayList<>();
        if (root!=null) {
            findPath(root, 0, expectedSum, list);
        }
    }

    public static void findPath(MyTreeNode root, int curSum, int expectedSum, List<Integer> result) {
        if (root!=null) {
            curSum += root.val;
            result.add(root.val);
            if (curSum<expectedSum) {
                //µÝ¹é×ó×ÓÊ÷
                findPath(root.left, curSum, expectedSum, result);
                //µÝ¹éÓÒ×ÓÊ÷
                findPath(root.right, curSum, expectedSum, result);
            } else if (curSum==expectedSum) {
                if (root.left==null && root.right==null) {
                    System.out.println(result);
                }
            }
            result.remove(result.size()-1);
        }
    }
}
