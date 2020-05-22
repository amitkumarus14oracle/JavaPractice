package daily.five.data.structure.questions.twenty2.may.twenty;

import daily.five.data.structure.questions.TreeNode;

public class MaxInBinaryTreeRecursive {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();
        int max = maxInBinaryTree(root);
        System.out.println(max);
    }

    private static int maxInBinaryTree(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if(root != null) {
            int leftMax = maxInBinaryTree(root.getLeft());
            int rightMax = maxInBinaryTree((root.getRight()));

            if(leftMax > rightMax) {
                max = leftMax;
            } else {
                max = rightMax;
            }

            if(root.getData() > max) {
                max = root.getData();
            }

        }
        return max;
    }
}
