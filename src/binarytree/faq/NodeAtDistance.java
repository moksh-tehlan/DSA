package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.*;

public class NodeAtDistance {
    public static void main(String[] args) {


    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //your code goes here
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        queue.offer(root);
        map.put(root, null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

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
        int distance = 0;
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
            if (distance == k) {
                break;
            }
        }
        return new ArrayList<>(queue.stream().map(node -> node.data).toList());
    }
}
