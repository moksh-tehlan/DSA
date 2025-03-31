package binarytree.medium;

import binarytree.traversal.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    private static boolean isSymmetric(TreeNode root) {
        //your code goes here
        return symmetryHelper(root.left,root.right);
    }

    private static boolean symmetryHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.data != right.data) return false;
        return symmetryHelper(left.left, right.right) & symmetryHelper(left.right, right.left);
    }
}
