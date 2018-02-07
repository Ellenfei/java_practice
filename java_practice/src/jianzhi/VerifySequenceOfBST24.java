package jianzhi;

/**
 * Created by Ellen on 2017/12/28.
 */
public class VerifySequenceOfBST24 {
    public static void main(String[] args) {
        int[] sequence = {5,7,6,8};
        System.out.println(verifySequenceOfBST(sequence, 0, sequence.length));
    }
    public static boolean verifySequenceOfBST(int[] sequence, int start, int length) {
        if (sequence==null || sequence.length==0) {
            return false;
        }
        //左结点小于根节点
        int root = sequence[length-1];
        int index = start; //记录左右子树的分开位置
        while (index<length-1 && sequence[index]<root) {
            index++;
        }

        //右节点大于根节点
        int rightIndex = index;
        while (rightIndex<length-1) {
            if (sequence[rightIndex]<root) {
                return false;
            }
            rightIndex++;
        }

        boolean left = true;
        if (index>0) {
            left = verifySequenceOfBST(sequence, 0, index);
        }
        boolean right = true;
        if (index<length-1) {
            right = verifySequenceOfBST(sequence, index,  length - 1 - index);
        }

        return left&right;
//      return verifySequenceOfBST(sequence, index) &&
//      verifySequenceOfBST(sequence, length - 1 - index);
    }
}
