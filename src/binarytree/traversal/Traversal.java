package binarytree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        List<Integer> ans = inorder(root);
//        List<Integer> ans = preorder(root);
//        List<Integer> ans = postorder(root);
        List<List<Integer>> ans = levelOrder(root);
        for (List<Integer> list : ans) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> inorder(TreeNode root) {
        return inorderHelper(root, new ArrayList<>());
    }

    private static List<Integer> inorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ans;
        }
        inorderHelper(root.left, ans);
        ans.add(root.data);
        inorderHelper(root.right, ans);
        return ans;
    }

    private static List<Integer> preorder(TreeNode root) {
        return preorderHelper(root, new ArrayList<>());
    }

    private static List<Integer> preorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ans;
        }
        ans.add(root.data);
        preorderHelper(root.left, ans);
        preorderHelper(root.right, ans);
        return ans;
    }

    private static List<Integer> postorder(TreeNode root) {
        return postorderHelper(root, new ArrayList<>());
    }

    private static List<Integer> postorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ans;
        }
        postorderHelper(root.left, ans);
        postorderHelper(root.right, ans);
        ans.add(root.data);
        return ans;
    }

    private static List<List<Integer>> treeTraversal(TreeNode root) {
        List<List<Integer>> givenList = new ArrayList<>();
        givenList.add(new ArrayList<>());
        givenList.add(new ArrayList<>());
        givenList.add(new ArrayList<>());
        return treeTraversalHelper(root, givenList);
    }

    private static List<List<Integer>> treeTraversalHelper(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return ans;
        }
        List<Integer> inorderList = ans.get(0);
        List<Integer> preOrderList = ans.get(1);
        List<Integer> postOrderlist = ans.get(2);

        preOrderList.add(root.data);
        ans.set(1, preOrderList);
        treeTraversalHelper(root.left, ans);
        inorderList.add(root.data);
        ans.set(0, inorderList);
        treeTraversalHelper(root.right, ans);
        postOrderlist.add(root.data);
        ans.set(2, postOrderlist);
        return ans;
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return ans;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) break;
                subList.add(node.data);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(subList);
        }
        return ans;
    }
}