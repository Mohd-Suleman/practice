package ds.trees;

import java.util.Scanner;

public class SimpleBinaryTree {
    private Node root;
    static class Node {
        private int value;
        private Node left;
        private Node right;
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter root node value!");
        int rootNodeValue = scanner.nextInt();
        root = new Node(rootNodeValue);
        populate(root, scanner);
    }
    private void populate(Node node, Scanner scanner) {
        System.out.println("Do you want to enter left of "+ node.value+" ?");
        boolean left = scanner.nextBoolean();
        if(left) {
            System.out.println("Enter value to be added at left of "+node.value);
            int leftValue = scanner.nextInt();
            node.left = new Node(leftValue);
            populate(node.left, scanner);
        }
        System.out.println("Do you want to enter right of "+ node.value+" ?");
        boolean right = scanner.nextBoolean();
        if(right) {
            System.out.println("Enter value to be added at right of "+node.value);
            int rightValue = scanner.nextInt();
            node.right = new Node(rightValue);
            populate(node.right, scanner);
        }
    }

    public void printTree() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if(node == null) {
            return;
        }
        display(node.right, level+1);
        if(level!=0) {
            for(int i=0; i<level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+node.value);
        } else
            System.out.println(node.value);

        display(node.left, level+1);
    }

    public static void main(String[] args) {
        SimpleBinaryTree tree = new SimpleBinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);
        tree.printTree();
    }
}
