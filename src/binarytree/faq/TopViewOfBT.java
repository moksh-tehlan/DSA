package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.*;

public class TopViewOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List result = topView(root);

        System.out.println("Top View: " + result);
    }

    private static List<Integer> topView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> verticalMap = new TreeMap<>();
        queue.offer(new Pair<>(root,0));

        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> poppedPair = queue.poll();
            TreeNode node = poppedPair.getKey();
            int line = poppedPair.getValue();

            if(!verticalMap.containsKey(line)){
                verticalMap.put(line,node.data);
            }

            if(node.left != null)queue.offer(new Pair<>(node.left,line-1));
            if(node.right != null)queue.offer(new Pair<>(node.right,line+1));
        }

        return new ArrayList<>(verticalMap.values());
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
