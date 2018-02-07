package demo1_3;

/**
 * Created by ye on 2017/1/12.
 */
public class symmeticTree {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.left.right  = new TreeNode(15);

        System.out.println(isSymmetric(root));
        System.out.println(root.right==root.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left,root.right);
    }

    public static boolean isSame(TreeNode left,TreeNode right) {
        if (left==null || right==null) {
            return left==right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSame(left.left,right.right) && isSame(left.right,right.left);
    }
}
