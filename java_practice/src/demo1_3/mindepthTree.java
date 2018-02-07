package demo1_3;

/**
 * Created by ye on 2017/1/17.
 */
public class mindepthTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
      //  root.left.right  = new MyTreeNode(15);

        System.out.print(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (root.left==null || root.right==null) ? left+right+1 : Math.min(left,right)+1;

    }
}
