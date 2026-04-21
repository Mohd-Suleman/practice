package leetcode150.binarytree;

import ds.trees.SimpleBinaryTree;

import java.util.*;

public class CustomBinaryTree {
    private Node root;

    static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(Scanner sc) {
        System.out.println("Enter root value: ");
        int rootValue = sc.nextInt();
        root = new Node(rootValue);
        insert(root, sc);
    }

    private void insert(Node node, Scanner sc) {
        System.out.println("Enter left of "+node.value+" ?");
        boolean left = sc.nextBoolean();
        if(left) {
            System.out.println("Enter left value of "+node.value);
            node.left = new Node(sc.nextInt());
            insert(node.left, sc);
        }
        System.out.println("Enter right of "+node.value+" ?");
        boolean right = sc.nextBoolean();
        if(right) {
            System.out.println("Enter right value of "+node.value);
            node.right = new Node(sc.nextInt());
            insert(node.right, sc);
        }
    }

    public void preOrderTraversalPrint(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value+" ");
        preOrderTraversalPrint(node.left);
        preOrderTraversalPrint(node.right);
    }

    public boolean isSameTree(Node r1, Node r2) {
        Queue<Node> q = new LinkedList<>();
        q.add(r1);
        q.add(r2);

        while(!q.isEmpty()) {
            Node first = q.poll();
            Node second = q.poll();

            if(first==null && second==null)
                continue;
            else if(first == null || second == null || first.value != second.value)
                return false;

            q.add(r1.left);
            q.add(r2.left);
            q.add(r1.left);
            q.add(r2.right);

        }
        return true;
    }

    public boolean isSameTreeUsingInOrderTraversal(Node root1, Node root2) {
        if(root1 == null || root2 == null)
            return false;
        List<Integer> list1 = inOrderTraversal(root1);
        List<Integer> list2 = inOrderTraversal(root2);

        System.out.println(list1);
        System.out.println(list2);

        if(list1.size() != list2.size())
            return false;

        for(int i=0; i<list1.size(); i++) {
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }

    private List<Integer> inOrderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        inOrderTraversal(root.left);
        list.add(root.value);
        inOrderTraversal(root.right);

        return list;
    }

    public Node invertUsingOrderLevelTraversal(Node root) {
        if(root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node currentNode = q.poll();

            Node temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            if(currentNode.left != null)
                q.add(currentNode.left);
            if(currentNode.right != null)
                q.add(currentNode.right);

        }

        return root;
    }

    public Node buildTreeFromPreAndInOrder(int[] preOrder, int[] inOrder) {
        if(preOrder.length == 0 || inOrder.length == 0 || preOrder.length!=inOrder.length)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inOrder.length; i++)
            map.put(inOrder[i], i);

        return splitTree(preOrder, map, 0, 0, inOrder.length-1);
    }

    private Node splitTree(int[] preOrder, Map<Integer, Integer> map, int rootIndex, int left, int right) {
        Node root = new Node(preOrder[rootIndex]);
        int mid = map.get(preOrder[rootIndex]);
        if(mid > left) {
            root.left = splitTree(preOrder, map, rootIndex+1, left, mid-1);
        } if(mid < right) {
            root.right = splitTree(preOrder, map, rootIndex+mid-left+1, mid+1, right);
        }
        return root;
    }

    /**
     * Explanation: https://www.youtube.com/watch?v=D8riBoRSwK8
     * Need to re-visit
     * */
    public Node buildTreeFromPostAndInOrder(int[] io, int[] po) {
        int ioLen = io.length;
        int poLen = po.length;
        if(poLen < 1 || ioLen != poLen)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<ioLen; i++)
            map.put(io[i], i);
        return buildTree(io, 0, ioLen-1, po, 0, poLen-1, map);
    }

    private Node buildTree(int[] io, int ioStart, int ioEnd,
                           int[] po, int poStart, int poEnd, Map<Integer, Integer> map) {
        if(ioStart > ioEnd || poStart > poEnd)
            return null;
        Node root = new Node(po[poEnd]);
        int rootIdx = map.get(po[poEnd]);
        int numsAtLeft = rootIdx - ioStart;

        root.left = buildTree(io, ioStart, rootIdx-1, po, poStart, poStart+numsAtLeft-1, map);

        root.right = buildTree(io, poStart+rootIdx+1, poEnd, po, poStart+numsAtLeft, poEnd-1, map);

        return root;

    }

    boolean flag = true;
    Node preNode = null;
    public boolean isBST(Node root) {
        inOrderForIsBST(root);
        return flag;
    }

    private void inOrderForIsBST(Node root) {
        if(root == null)
            return;
        inOrderForIsBST(root.left);
        if(preNode != null) {
            if(preNode.value > root.value) {
                flag = false;
                return;
            }
        }
        preNode = root;
        inOrderForIsBST(root.right);

    }
    public static void main(String[] args) {
        CustomBinaryTree tree = new CustomBinaryTree();
        tree.insert(new Scanner(System.in));

        tree.preOrderTraversalPrint(tree.root);

        System.out.println("Is BST --> "+ tree.isBST(tree.root));

//        System.out.println("Is same Tree: "+tree.isSameTree(tree.root, tree.root));
//
//        System.out.println("After inverting:");
//        tree.preOrderTraversalPrint(tree.invertUsingOrderLevelTraversal(tree.root));
        /*int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        Node newNode = tree.buildTreeFromPreAndInOrder(preOrder, inOrder);
        tree.preOrderTraversalPrint(newNode);*/

        /*int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        Node newNode = tree.buildTreeFromPostAndInOrder(inOrder, postOrder);
        tree.preOrderTraversalPrint(newNode);*/
        System.out.println(tree.rightSideView(tree.root));
    }

    public List<Integer> rightSideView(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            list.add(cur.value);

            if(cur.right != null) queue.offer(cur.right);
            if(cur.left != null) queue.offer(cur.left);
        }
        return list;

    }

}
