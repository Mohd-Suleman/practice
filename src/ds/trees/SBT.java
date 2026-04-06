package ds.trees;

import java.util.Scanner;

public class SBT {
    private Node root;

    static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    public void populate(Scanner sc) {
        System.out.println("Enter root node - > ");
        int rootValue = sc.nextInt();
        root = new Node(rootValue);
        populate(root, sc);
    }

    private void populate(Node node, Scanner sc) {
        System.out.println("Do you wan to insert left of "+node.value+" true/false");
        boolean left = sc.nextBoolean();
        if(left) {
            System.out.println("Enter value: ");
            int leftValue = sc.nextInt();
            node.left = new Node(leftValue);
            populate(node.left, sc);
        }
        System.out.println("Do you wan to insert right of "+node.value+" true/false");
        boolean right = sc.nextBoolean();
        if(right) {
            System.out.println("Enter value: ");
            int rightValue = sc.nextInt();
            node.left = new Node(rightValue);
            populate(node.right, sc);
        }
    }
}
