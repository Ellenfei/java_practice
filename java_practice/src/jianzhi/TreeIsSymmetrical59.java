package jianzhi;

/**
 * Created by Ellen on 2018/1/31.
 * 判断一个二叉树是否对称
 */
class MyBinaryTree {
    int val;
    MyBinaryTree left;
    MyBinaryTree right;
    public MyBinaryTree (int val) {
        this.val = val;
    }
//    @Override
    public String toString (int val) {
        return val+" ";
    }
}
public class TreeIsSymmetrical59 {
    public static void main(String[] args) {
        MyBinaryTree n1 = new MyBinaryTree(1);
        MyBinaryTree n2 = new MyBinaryTree(2);
        MyBinaryTree n3 = new MyBinaryTree(2);
        MyBinaryTree n4 = new MyBinaryTree(4);
        MyBinaryTree n5 = new MyBinaryTree(4);
        MyBinaryTree n6 = new MyBinaryTree(4);
        assemble(n1, n2, n3);
        assemble(n2, n4, null);
        assemble(n3, null, n6);
        System.out.println(isSymmetric(n1));
    }
    //判断是否对称
    public static boolean isSymmetric (MyBinaryTree root) {
        if (root==null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(MyBinaryTree left, MyBinaryTree right) {
        if (left==null && right==null) {
            return true;
        }
        if (left==null || right==null) {
            return false;
        }
        if (left.val!=right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) &&
                isSymmetric(left.right, right.left);
    }
    //构建树
    public static void assemble (MyBinaryTree node, MyBinaryTree left, MyBinaryTree right) {
        node.left = left;
        node.right = right;
    }
}
