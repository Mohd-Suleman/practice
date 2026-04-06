package ds.trees;

public class BST {
    private Node root;
    static class Node{
        private int value;
        private Node left;
        private Node right;
        int height;
        Node(int value) {
            this.value = value;
        }
    }

    int getHeight(Node node) {
        if(node == null)
            return -1;
        return node.height;

    }
    public void insert(int value) {
        root = insert(root, value);
    }
    private Node insert(Node node, int value) {
        if(node == null) {
            node = new Node(value);
            return node;
        }
        if(value < node.value) {
            node.left = insert(node.left, value);
        }
        if(value > node.value) {
            node.right = insert(node.right, value);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    public void display() {
        display(root, "Root Node");
    }

    private void display(Node node, String details) {
        if(node == null)
            return;
        System.out.println(details+" : "+node.value);
        display(node.left, "Left child of Node "+node.value);
        display(node.right, "Right child of Node "+node.value);
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }



    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(20);
        bst.display();
        System.out.println("Pre-order traversal: ");
        bst.preOrder();
        System.out.println();
        System.out.println("In-order traversal: ");
        bst.inOrder();
        System.out.println();
        System.out.println("Post-order traversal: ");
        bst.postOrder();

    }
}
