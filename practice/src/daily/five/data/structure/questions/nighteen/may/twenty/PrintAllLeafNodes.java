package daily.five.data.structure.questions.nighteen.may.twenty;

import daily.five.data.structure.questions.TreeNode;

public class PrintAllLeafNodes {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();
        printLeafNodes(root);
    }
    public static void printLeafNodes(TreeNode root) {
        if(root.getLeft() == null && root.getRight() == null) {
            System.out.println(root.getData()); // leaf node data
        } else {
            printLeafNodes(root.getLeft());
            printLeafNodes(root.getRight());
        }
    }
}
