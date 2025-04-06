package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToLeaf {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        allRootToLeafHelper(root, ans, new ArrayList<>());
        return ans;
    }

    public static void allRootToLeafHelper(TreeNode root, List<List<Integer>> ans, List<Integer> currList) {
        if (root == null) {
            return;
        }

        currList.add(root.data);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(currList));
        } else {
            allRootToLeafHelper(root.left, ans, currList);
            allRootToLeafHelper(root.right, ans, currList);
        }
        currList.remove(currList.size() - 1);
    }
}
