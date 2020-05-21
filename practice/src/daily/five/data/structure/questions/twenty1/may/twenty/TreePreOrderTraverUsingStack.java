package daily.five.data.structure.questions.twenty1.may.twenty;

import daily.five.data.structure.questions.TreeNode;

import java.util.Stack;

public class TreePreOrderTraverUsingStack {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();
        preOrderUsingStack(root);
    }

    private static void preOrderUsingStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode ptr = s.pop();
            System.out.println(ptr.getData());
            if(ptr.getRight() != null) {
                s.push(ptr.getRight());
            }
            if(ptr.getLeft() != null) {
                s.push(ptr.getLeft());
            }
        }
    }
}
