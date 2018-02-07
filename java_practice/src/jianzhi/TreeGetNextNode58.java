package jianzhi;

/**
 * Created by Ellen on 2018/1/30.
 * ˼·��
 * 1.�˽ڵ�����ҽڵ㣬�򷵻��ҽڵ������ڵ�
 * 2.�˽ڵ㲻�����ҽڵ㣬�Ǹ��ڵ���ڵ㣬���ظ��ڵ�
 * 3.�˽ڵ㲻�����ҽڵ�㣬�Ǹ��ڵ��ҽڵ㣬���ϱ������ڵ㣬ֱ��ĳ���ڵ����丸�ڵ����ڵ㣬���ظø��ڵ�
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
    //�õ������������������һ���ڵ�
    public static BinaryTree getNext(BinaryTree root, BinaryTree node) {
        if (root==null || node==null) {
            return null;
        }
        //Ŀ��ڵ�
        BinaryTree target = null;
        //1.�ýڵ�����ҽڵ�,�����ҽڵ������ڵ�
        if (node.right!=null) {
            target = node.right;
            while (target.left!=null) {
                target = target.left;
            }
            return target;
        } else if (node.parent!=null) {
            //3.�˽ڵ㲻�����ҽڵ㣬�Ǹ��ڵ��ҽڵ㣬���ϱ������ڵ㣬ֱ��ĳ���ڵ����丸�ڵ����ڵ㣬���ظø��ڵ�
            target = node.parent;
            BinaryTree cur = node;
            while (target!=null && target.left!=cur) {
                cur = target;
                target = target.parent;
            }
            return target;
        }
/*        //2.�˽ڵ㲻�����ҽڵ㣬�Ǹ��ڵ���ڵ㣬���ظ��ڵ�
        if (node.parent!=null && node.parent.left==node) {
            target = node.parent;
            return target;
        }
        //3.�˽ڵ㲻�����ҽڵ㣬�Ǹ��ڵ��ҽڵ㣬���ϱ������ڵ㣬ֱ��ĳ���ڵ����丸�ڵ����ڵ㣬���ظø��ڵ�
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
    //������
    public static void asseblem(BinaryTree node, BinaryTree left, BinaryTree right, BinaryTree parent) {
        node.left = left;
        node.right = right;
        node.parent = parent;
    }
}
