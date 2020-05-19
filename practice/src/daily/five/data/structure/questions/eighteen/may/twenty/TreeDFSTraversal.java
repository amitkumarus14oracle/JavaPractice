package daily.five.data.structure.questions.eighteen.may.twenty;

import daily.five.data.structure.questions.TreeNode;

public class TreeDFSTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null))
        );
        System.out.println("Printing preorder representation of tree");
        printPreOrder(root);
        System.out.println("Printing inorder representation of tree");
        printInOrder(root);
        System.out.println("Printing postorder representation of tree");
        printPostOrder(root);

    }

    private static void printInOrder(TreeNode root) {
        if(root != null) {
            printInOrder(root.getLeft());
            System.out.println(root.getData());
            printInOrder(root.getRight());
        }
    }

    private static void printPreOrder(TreeNode root) {
        if(root != null) {
            System.out.println(root.getData());
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }
    }

    private static void printPostOrder(TreeNode root) {
        if(root != null) {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
}
