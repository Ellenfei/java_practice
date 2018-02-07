package jianzhi;

/**
 * Created by Ellen on 2018/2/1.
 * 二叉搜索树的第k个节点
 * 按照中序遍历找到第k个节点
 */
public class TreeKthNode63 {
    public static void main(String[] args) {
        MyBinaryTree root = new MyBinaryTree(1);
        root.left = new MyBinaryTree(2);
        root.right = new MyBinaryTree(3);
        root.left.left = new MyBinaryTree(4);
        root.left.right = new MyBinaryTree(5);
        System.out.print(KthNode(root, 3).val);
    }
    //二叉搜索树的第k个节点
    public static MyBinaryTree KthNode(MyBinaryTree root, int k) {
        if (root==null || k<1) {
            return null;
        }
        int[] tmp = {k};
        return KthNodeCore(root, tmp);
    }
    public static MyBinaryTree KthNodeCore(MyBinaryTree root, int[] k) {
        MyBinaryTree result = null;
        //先找左子树
        if (root.left!=null) {
            result = KthNodeCore(root.left, k);
        }
        //如果在左子树中没有找到
        if (result==null) {
            //k=1时，找到该节点
            if (k[0]==1) {
                result = root;
            } else {
                //当前节点不是所要找的节点
                k[0]--;
            }
        }
        //没有找到，找右zishu
        if (result==null && root.right!=null) {
            result = KthNodeCore(root.right, k);
        }
        return result;
    }
}
