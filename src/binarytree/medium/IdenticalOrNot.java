package binarytree.medium;

import binarytree.traversal.TreeNode;

public class IdenticalOrNot {
    public static void main(String[] args) {

    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.data != q.data) {
            return false;
        }

        boolean leftCheck = isSameTree(p.left, q.left);
        boolean rightCheck = isSameTree(p.right, q.right);
        return leftCheck && rightCheck;
    }
}
