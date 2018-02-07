package jianzhi;

/**
 * Created by Ellen on 2018/2/1.
 * �����������ĵ�k���ڵ�
 * ������������ҵ���k���ڵ�
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
    //�����������ĵ�k���ڵ�
    public static MyBinaryTree KthNode(MyBinaryTree root, int k) {
        if (root==null || k<1) {
            return null;
        }
        int[] tmp = {k};
        return KthNodeCore(root, tmp);
    }
    public static MyBinaryTree KthNodeCore(MyBinaryTree root, int[] k) {
        MyBinaryTree result = null;
        //����������
        if (root.left!=null) {
            result = KthNodeCore(root.left, k);
        }
        //�������������û���ҵ�
        if (result==null) {
            //k=1ʱ���ҵ��ýڵ�
            if (k[0]==1) {
                result = root;
            } else {
                //��ǰ�ڵ㲻����Ҫ�ҵĽڵ�
                k[0]--;
            }
        }
        //û���ҵ�������zishu
        if (result==null && root.right!=null) {
            result = KthNodeCore(root.right, k);
        }
        return result;
    }
}
