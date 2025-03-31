package binarytree.medium;

import binarytree.traversal.TreeNode;

public class MaxPathSum {
    public static void main(String[] args) {
    }

    private static int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        nodeHeightCalculator(root,max);
        return max[0];
    }


    private static int nodeHeightCalculator(TreeNode root, int[] max) {
        if (root == null) return 0;
        int leftNodeHeightSum = Math.max(0, nodeHeightCalculator(root.left, max));
        int rightNodeHeightSum = Math.max(0, nodeHeightCalculator(root.right, max));
        max[0] = Math.max(max[0],leftNodeHeightSum+rightNodeHeightSum+root.data);

        return Math.max(leftNodeHeightSum, rightNodeHeightSum) + root.data;
    }
}
