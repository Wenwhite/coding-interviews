package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test07
 * @Author: wenbai
 * @Description: 剑指offer第7题 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树
 * 假设输入的前序遍历和中序遍历的结果都不含重复的数字
 * @Date: 2019/9/14 0:26
 * @Version: 1.0
 */
public class Test07 {

    /**
     * 二叉树的节点
     */
    static class TreeNode{

        int value;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(){

        }

        TreeNode(int value){
            this.value = value;
            leftNode = null;
            rightNode = null;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
        TreeNode root = reConstructBinaryTree( preorder, 0, preorder.length-1, inorder, 0, inorder.length );
        return root;
    }

    /**
     * 通过递归 进行重建
     * 前序序列的第一项为当前节点的值
     * 中序遍历中 当前节点项前面的序列是当前节点的左子树的中序序列 当前节点项后面的序列是当前节点的右子树的中序序列
     * 在中序遍历中获取左右子树的中序序列的长度 并以此在前序序列中确定对应的左右子树的前序序列
     * 进行递归 直到preStart > preEnd || inStart > inEnd 表示当前节点为空
     * @param preorder 前序序列
     * @param preStart 前序序列开始项
     * @param preEnd 前序序列结束项
     * @param inorder 后序序列
     * @param inStart 后序序列开始项
     * @param inEnd 后序序列结束项
     * @return 当前节点
     */
    private static TreeNode reConstructBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if ( preStart > preEnd || inStart > inEnd ) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = inStart;
        int leftLength = 0;
        int rightLength = inStart;
        for (int i = inStart; i < inEnd; i++) {
            if ( inorder[i] == node.value ) {
                index = i;
                break;
            }
        }
        leftLength = index - inStart;
        rightLength = inEnd - index;
        node.leftNode = reConstructBinaryTree(preorder, preStart+1, preStart + leftLength, inorder, inStart, index-1);
        node.rightNode = reConstructBinaryTree(preorder, preStart + 1 + leftLength, preEnd, inorder, index+1, inEnd);
        return node;
    }

    /**
     * 前序遍历 并打印
     * @param root 根节点
     */
    static void prePrintTree( TreeNode root ) {
        if ( root==null ) {
            return;
        }

        System.out.print(root.value + " ");
        prePrintTree(root.leftNode);
        prePrintTree(root.rightNode);
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        prePrintTree(root);
    }

}
