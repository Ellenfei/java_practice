package jianzhi;

/**
 * Created by Ellen on 2018/1/30.
 * 思路：
 * 1.此节点存在右节点，则返回右节点的最左节点
 * 2.此节点不存在右节点，是父节点左节点，返回父节点
 * 3.此节点不存在右节点点，是父节点右节点，向上遍历父节点，直到某个节点是其父节点的左节点，返回该父节点
 */
class BinaryTree {
    int val;
    BinaryTree left = null;
    BinaryTree right = null;
    BinaryTree parent = null;
    public BinaryTree(int val) {
        this.val = val;
    }
    public String toString(){
        return val+" ";
    }
}
public class TreeGetNextNode58 {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.parent = root;
        root.right = new BinaryTree(3);
        root.right.parent = root;
        root.left.left = new BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.right.right = new BinaryTree(7);
        root.left.right.right.parent = root.left.right;
        root.left.left.right = new BinaryTree(6);
        root.left.left.right.parent = root.left.left;
        System.out.println(getNext(root, root.left.right.right).val);
    }
    //得到二叉树中序遍历的下一个节点
    public static BinaryTree getNext(BinaryTree root, BinaryTree node) {
        if (root==null || node==null) {
            return null;
        }
        //目标节点
        BinaryTree target = null;
        //1.该节点存在右节点,返回右节点的最左节点
        if (node.right!=null) {
            target = node.right;
            while (target.left!=null) {
                target = target.left;
            }
            return target;
        } else if (node.parent!=null) {
            //3.此节点不存在右节点，是父节点右节点，向上遍历父节点，直到某个节点是其父节点的左节点，返回该父节点
            target = node.parent;
            BinaryTree cur = node;
            while (target!=null && target.left!=cur) {
                cur = target;
                target = target.parent;
            }
            return target;
        }
/*        //2.此节点不存在右节点，是父节点左节点，返回父节点
        if (node.parent!=null && node.parent.left==node) {
            target = node.parent;
            return target;
        }
        //3.此节点不存在右节点，是父节点右节点，向上遍历父节点，直到某个节点是其父节点的左节点，返回该父节点
        if (node.parent!=null && node.parent.right==node) {
            target = node.parent;
            while (target.parent!=null && target.parent.left!=target) {
                target = target.parent;
            }
            target = target.parent;
            return target;
        }*/
        return null;
    }
    //构建树
    public static void asseblem(BinaryTree node, BinaryTree left, BinaryTree right, BinaryTree parent) {
        node.left = left;
        node.right = right;
        node.parent = parent;
    }
}
