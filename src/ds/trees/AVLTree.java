package ds.trees;

public class AVLTree {
    private Node root;
    static class Node {
        int value;
        Node left;
        Node right;
        int height;
        Node(int value) {
            this.value = value;
        }
    }

    public int getHeight(Node node) {
        if(node == null)
            return -1;
        return node.height;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if(node == null) {
            node = new Node(value);
            return node;
        }

        if(value < node.value)
            node.left = insert(value, node.left);
        else if(value > node.value)
            node.right = insert(value, node.right);

        node.height = Math.max(getHeight(node.right), getHeight(node.left))+1;
        return rotate(node);
    }

    public Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;
        //Rotating left
        c.left = p;
        p.left = t;

        //Adjust height
        p.height = Math.max(getHeight(p.left), getHeight(p.right))+1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right))+1;

        return c;

    }
    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right; // p.left.right;

        //Rotating right
        c.right = p;
        p.right = t;

        //Adjust height
        p.height = Math.max(getHeight(p.left), getHeight(p.right))+1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right))+1;

        return c;
    }

    public Node rotate(Node node) {
        if(getHeight(node.right) - getHeight(node.left) < -1) {
            // left heavy
            if(getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                // left-left case
                // Right rotate at Node P
                node.right = rightRotate(node);
            } if(getHeight(node.left.left) - getHeight(node.left.right) > 0) {
                // left-right case
                // Left rotate at Node C(node.left)
            }
        }
        if(getHeight(node.right) - getHeight(node.left) > 1) {
            // right heavy
            if(getHeight(node.right.right) - getHeight(node.right.left) > 0) {
                // right-right case
                // Left rotate at Node P
                node.left = leftRotate(node);
            } if(getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                // right-left case
                // Right rotate at Node C(node.right)
            }
        }
        return node;
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

    public static void main(String arg[]) {
        AVLTree tree = new AVLTree();
//        tree.insert(15);
//        tree.insert(10);
//        tree.insert(50);
//        tree.insert(5);
//        tree.insert(8);

        int[] arr = {15,10,50,12,5,2,3};

        for(int i: arr)
            tree.insert(i);
//        tree.printTree();

        tree.preOrder();
    }
}
