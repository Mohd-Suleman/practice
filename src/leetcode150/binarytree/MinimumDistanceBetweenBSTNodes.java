package leetcode150.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDistanceBetweenBSTNodes {

    private Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return root;
        }
        if(value > root.value) {
            root.right = insert(root.right, value);
        }
        if(value < root.value) {
            root.left = insert(root.left, value);
        }
        return root;
    }

    public void leveOrderTraversal(Node node) {
        if(node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.value+"->");
            if(currentNode.left != null)
                queue.offer(currentNode.left);
            if(currentNode.right != null)
                queue.offer(currentNode.right);
        }
        System.out.println();
    }


    /**
     * Explanation: https://www.youtube.com/watch?v=_7iZek8YsX4
     * TC: O(n)
     * SC: O(h)
     * */
    private Node preNode;
    private int minDiff = Integer.MAX_VALUE;
    public int getMinDiff(Node root) {
        inOrderForMinDiff(root);
        return minDiff;
    }

    private void inOrderForMinDiff(Node root) {
        if(root == null) {
            return;
        }
        inOrderForMinDiff(root.left);
        if(preNode != null) {
            minDiff = Math.min(minDiff, Math.abs(root.value - preNode.value));
        }
        preNode = root;
        inOrderForMinDiff(root.right);
    }



    public int KthSmallestElement(Node root, int k) {
        List<Integer> list = new ArrayList<>();

        return inOrderForSmallestElement(root, list).get(k-1);
    }
    private List<Integer> inOrderForSmallestElement(Node root, List<Integer> list) {
        if(root == null)
            return list;

        inOrderForSmallestElement(root.left, list);
        list.add(root.value);
        inOrderForSmallestElement(root.right, list);
        return list;

    }


    /**
     * Explanation: https://www.youtube.com/watch?v=k368NWnUFFI*/
    int smallestElement = 0;
    int k;
    public int KthSmallestElementOptimized(Node root, int k) {
        this.k = k;
        inOrderOptimized(root);
        return smallestElement;
    }

    private void inOrderOptimized(Node root) {
        if(root == null)
            return;

        inOrderOptimized(root.left);
        if(--k == 0) {
            smallestElement = root.value;
            return;
        }
        inOrderOptimized(root.right);

    }
    public static void main(String[] args) {
        MinimumDistanceBetweenBSTNodes tree = new MinimumDistanceBetweenBSTNodes();
        tree.insert(10);

        tree.insert(4);
        tree.insert(15);
        tree.insert(6);
        tree.insert(1);
        tree.insert(8);


        tree.leveOrderTraversal(tree.root);

        System.out.println("Min Abs diff: "+tree.getMinDiff(tree.root));

        int k = 3;
        System.out.println(k+" smallest element "+tree.KthSmallestElementOptimized(tree.root, k));


    }
}
