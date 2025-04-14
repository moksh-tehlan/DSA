package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.*;

public class TimerToBurnTree {
    public static void main(String[] args) {

    }

    private static int timeToBurnTree(TreeNode root, int start) {
        //your code goes here
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = null;
        queue.offer(root);
        map.put(root, null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.data == start) {
                target = node;
            }

            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right, node);
            }
        }

        queue.offer(target);
        Set<TreeNode> visitedNodes = new HashSet<>();
        int distance = -1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0 && !queue.isEmpty()) {
                TreeNode node = queue.poll();
                visitedNodes.add(node);

                if (node.left != null && !visitedNodes.contains(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && !visitedNodes.contains(node.right)) {
                    queue.offer(node.right);
                }
                if (map.get(node) != null && !visitedNodes.contains(map.get(node))) {
                    queue.offer(map.get(node));
                }
            }
            distance++;
        }
        return distance;
    }
}
