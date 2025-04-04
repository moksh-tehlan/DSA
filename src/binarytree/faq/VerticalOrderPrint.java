package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.*;

public class VerticalOrderPrint {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalTraversal(root);
        System.out.println("Vertical Traversal:");
        for (List<Integer> column : result) {
            System.out.println(column);
        }
    }

    private static List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // vertical axis, then level axis
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0, 0, root));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            // Add the node's value to the map at the correct x and y
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.data);

            // Add the left child with updated coordinates to the queue
            if (node.left != null) {
                queue.offer(new Tuple(x - 1, y + 1, node.left));
            }

            // Add the right child with updated coordinates to the queue
            if (node.right != null) {
                queue.offer(new Tuple(x + 1, y + 1, node.right));
            }
        }

        for (Map<Integer, PriorityQueue<Integer>> levelMap : map.values()) {
            List<Integer> currAnswer = new ArrayList<>();
            for (PriorityQueue<Integer> values : levelMap.values()) {
                while (!values.isEmpty()){
                    currAnswer.add(values.poll());
                }
            }
            ans.add(currAnswer);
        }
        return ans;
    }
}

class Tuple {
    int y;
    int x;
    TreeNode node;

    public Tuple(int x, int y, TreeNode node) {
        this.x = x;
        this.y = y;
        this.node = node;
    }
}
