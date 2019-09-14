package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test08
 * @Author: wenbai
 * @Description: 剑指offer第8题 二叉树的下一个节点
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？数中的节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针
 * @Date: 2019/9/14 23:50
 * @Version: 1.0
 */
public class Test08 {

    class TreeNode{

        int value;
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode pNode;

    }

    /**
     * 分情况讨论 中序遍历顺序为左 中 右
     * 1.当前节点有右子树 则下一个节点为当前节点右子树的最左子节点 即从右子树出发 一直沿着左子节点走到头就行
     * 2.当前节点没有右子树 此时可以分为
     * a.当前节点是其父节点的左子树 则下一节点为当前节点的父节点
     * b.当前节点是其父节点的右子树 则需要沿着指向父节点的指针不断向上遍历 直到找到一个是它父节点的左子节点的节点
     * 如果该节点存在 那么下一个节点就是该节点的父节点
     * @param root 传入的节点
     * @return
     */
    public TreeNode getNextNode( TreeNode root ) {

        /**
         * 情况1
         */
        if ( root.rightNode!=null ) {
            root = root.rightNode;
            while ( root.leftNode!=null ) {
                root = root.leftNode;
            }
            return root;
        }

        /**
         * 情况a
         */
        while ( root.pNode != null && root == root.pNode.rightNode ) {
            root = root.pNode;
        }

        return root.pNode;
    }

}
