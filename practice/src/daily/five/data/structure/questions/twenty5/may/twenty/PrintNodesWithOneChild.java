package daily.five.data.structure.questions.twenty5.may.twenty;

import daily.five.data.structure.questions.TreeNode;

public class PrintNodesWithOneChild {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();
        TreeNode root1 = new TreeNode(1, new TreeNode(2, null, null), null);
        printOneChildNode(root);
        printOneChildNode(root1);

    }

    private static void printOneChildNode(TreeNode root) {
        if(root == null || (root.getLeft() != null && root.getRight() == null) || (root.getLeft() == null && root.getRight() != null) ) {
            if(root != null)
            System.out.println(root.getData());
            return;
        } else {
            printOneChildNode(root.getLeft());
            printOneChildNode(root.getRight());
        }
    }
}
