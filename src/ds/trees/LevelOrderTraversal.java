package ds.trees;

import java.sql.SQLOutput;
import java.util.*;

public class LevelOrderTraversal {
    static class Node {
        int value;
        Node left;
        Node right;
        int height;

        Node(int value) {
            this.value = value;
        }
    }

    Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if(node == null) {
            node = new Node(value);
            return node;
        }
        if(value > node.value) {
            node.right = insert(node.right, value);
        }
        if(value < node.value) {
            node.left = insert(node.left, value);
        }
        return node;
    }

    public void printTree(){
        printTree(root, "Root Node: ");
    }

    private void printTree(Node node, String details) {
        if(node == null) {
            return;
        }
        System.out.println(details+" "+node.value);
        printTree(node.left, "Left child of "+node.value+": ");
        printTree(node.right, "Right child of "+node.value+": ");
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

    public void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }

    public List<List<Integer>> nodeWithLevel(Node node) {
        List<List<Integer>> finalResult = new ArrayList<>();
        if(node == null)
            return finalResult;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int leveSize = queue.size();
            List<Integer> currentLevelValue = new ArrayList<>(leveSize);

            for(int i=0; i<leveSize; i++) {
                Node currentNode = queue.poll();
                currentLevelValue.add(currentNode.value);
                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            finalResult.add(currentLevelValue);

        }
        return finalResult;
    }

    public int heightWithLevelOrderTraversal(Node root) {
        int level = -1;
        if(root == null)
            return level;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(true) {
            int nodesAtLevel = queue.size();
            if(nodesAtLevel == 0)
                return level;

            while (nodesAtLevel > 0) {
                Node currentNode = queue.poll();
                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
                nodesAtLevel--;
            }
            level++;
        }
    }

    public int rangeSumBST(Node root, int low, int high) {
        if(root == null) {
            return 0;
        }
        int sum = 0;

        if(root.value > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if(root.value >= low && root.value <= high) {
            sum = sum+root.value;
        }
        if(root.value <= high)
            sum += rangeSumBST(root.right, low, high);
        return sum;
    }

    public List<List<Integer>> avgValueOfNodesAtEachLevel(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> avgAtLevel = new ArrayList<>();
            int sumOfNodesAtLevel = 0;
            for(int i=0; i<size; i++) {
                Node curretNode = queue.poll();
                sumOfNodesAtLevel += curretNode.value;
                if(curretNode.left != null) {
                    queue.offer(curretNode.left);
                }
                if(curretNode.right != null) {
                    queue.offer(curretNode.right);
                }
            }
            avgAtLevel.add(sumOfNodesAtLevel/size);
            result.add(avgAtLevel);
        }
        return result;
    }

    public int nodeWithMinimumDepth(Node node) {
        int level = -1;
        if(node == null) return level;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i=0; i<size; i++) {
                Node currentNode = queue.poll();
                if(currentNode.left == null && currentNode.right == null) {
                    System.out.println("Node with minimum depth is: "+currentNode.value);
                    return level;
                }
                if(currentNode.left !=null)
                    queue.offer(currentNode.left);
                if(currentNode.right !=null)
                    queue.offer(currentNode.right);
            }
        }
        return level;
    }

    public boolean pathSum(Node node, int target) {
        if(node == null) return false;
        Stack<Node> pathStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        pathStack.push(node);
        sumStack.push(node.value);

        while(!pathStack.isEmpty()) {
            Node tempNode = pathStack.pop();
            int tempValue = sumStack.pop();

            if(tempValue == target && tempNode.left == null && tempNode.right == null) {
                return true;
            }

            if(tempNode.left != null) {
                pathStack.push(tempNode.left);
                sumStack.push(tempNode.left.value+tempValue);
            } if(tempNode.right != null) {
                pathStack.push(tempNode.right);
                sumStack.push(tempNode.right.value+tempValue);
            }

        }
        return false;
    }

    public boolean isSameTreeUsingInorder(Node root1, Node root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        List<Integer> list1 = inOrderForSameTreeCompare(root1);

        List<Integer> list2 = inOrderForSameTreeCompare(root2);

        if(list1.size() != list2.size())
            return false;

        for(int i=0; i< list2.size(); i++) {
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }

    private List<Integer> inOrderForSameTreeCompare(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        inOrderForSameTreeCompare(root.left);
        System.out.print(root.value+" ");
        list.add(root.value);
        inOrderForSameTreeCompare(root.right);
        return list;
    }



    public boolean isSameTreeUsingOrderLevel(Node root1, Node root2) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);

        while (!queue.isEmpty()) {
            Node first = queue.poll();
            Node second = queue.poll();

            if(first == null && second == null) {
                continue;
            } else if(first == null && second == null && first.value != second.value) {
                return false;
            }

            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;
    }

    public Node invertTreeUsingLeveOrderTraversal(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node curNode = queue.poll();

            Node tempNode = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempNode;

            if(root.left != null)
                queue.offer(root.left);
            if(root.right != null)
                queue.offer(root.right);
        }
        return root;
    }

    public boolean isBinarySearchTree(Node node) {
        List<Integer> list = new LinkedList<>();
        if(node == null) {
            return false;
        }
        inOrderForBST(node, list);

        int pre = list.get(0);

        for(int i=1; i<list.size(); i++) {
            int currentValue = list.get(i);
            if(list.get(i) <= pre)
                return false;
            pre = currentValue;
        }
        return true;
    }

    private void inOrderForBST(Node node, List<Integer> list) {
        if(node == null) {
            return ;
        }
        inOrderForBST(node.left, list);
        list.add(node.value);
        inOrderForBST(node.right, list);
    }

    public List<List<Integer>> zigZagTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;

        while(!queue.isEmpty()) {
            int leveSize = queue.size();
            List<Integer> levels = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<leveSize; i++) {
                Node currentNode = queue.poll();
                if(flag)
                    stack.push(currentNode.value);
                else
                    levels.add(currentNode.value);

                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
            flag = !flag;
            while(!stack.isEmpty()) {
                levels.add(stack.pop());
            }

            result.add(levels);
        }
        return result;
    }


    public boolean isSubTree(Node fullTreeRoot, Node subTreeNode) {
        String fullTree = isSubTreePreOrderTraversal(fullTreeRoot);
        String subTree = isSubTreePreOrderTraversal(subTreeNode);

        return fullTree.contains(subTree);

    }

    private String isSubTreePreOrderTraversal(Node root) {
        if(root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.value);
        sb.append(isSubTreePreOrderTraversal(root.left));
        sb.append(isSubTreePreOrderTraversal(root.right));

        return sb.toString();
    }

    // Build max tree from give array with some rules
    public Node constructMaxBT(int[] nums) {
        if(nums == null) {
            return null;
        }

        return buildNodes(nums, 0, nums.length-1);
    }

    private Node buildNodes(int[] arr, int start, int end) {
        if(start > end)
            return null;

        int maxIndex = start;
        for(int i=start+1; i<=end; i++) {
            if(arr[i] > arr[maxIndex])
                maxIndex = i;
        }

        Node root = new Node(arr[maxIndex]);

        root.left = buildNodes(arr, start, maxIndex-1);
        root.left = buildNodes(arr, maxIndex+1, end);

        return root;
    }

    public boolean isSymmetric(Node root) {
        if(root == null) return true;
        Queue<Node> leftQ = new LinkedList<>();
        Queue<Node> rightQ = new LinkedList<>();

        while(!leftQ.isEmpty() && !rightQ.isEmpty()) {
            Node leftNode = leftQ.poll();
            Node rightNode = rightQ.poll();

            if(leftNode == null && rightNode == null) continue;

            if(leftNode == null || rightNode == null) return false;

            if(leftNode.value != rightNode.value) return false;

            leftQ.offer(leftNode.left);
            leftQ.offer(leftNode.right);

            rightQ.offer(rightNode.right);
            rightQ.offer(rightNode.left);
        }
        return true;
    }

    public List<Integer> rightView(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            int rightValue = 0;
            for(int i=0; i<levelSize; i++){
                Node tempNode = queue.poll();
                rightValue = tempNode.value;

                if(tempNode.left!=null)
                    queue.offer(tempNode.left);
                if(tempNode.right!=null)
                    queue.offer(tempNode.right);
            }
            result.add(rightValue);

        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        traversal.printTree();
        traversal.insert(10);
        traversal.insert(5);
        traversal.insert(15);
        traversal.insert(25);
        traversal.insert(8);
        traversal.insert(3);
        traversal.insert(30);
        traversal.insert(35);
        traversal.insert(21);
        traversal.insert(14);
        traversal.insert(1);
        traversal.insert(7);
        traversal.printTree();
        System.out.println("Order leve Traversal: ");
        traversal.leveOrderTraversal(traversal.root);
        System.out.println("Pre-Order Traversal: ");
        traversal.preOrder(traversal.root);
        System.out.println("In-Order Traversal: ");
        traversal.inOrder(traversal.root);
        System.out.println();
        System.out.println("Post-Order Traversal: ");
        traversal.postOrder(traversal.root);
        System.out.println();
        System.out.println("Node(s) at level: "+traversal.nodeWithLevel(traversal.root));
        System.out.println("Height of BST: "+traversal.heightWithLevelOrderTraversal(traversal.root));
        int low = 8; int high = 21;
        System.out.println("Sum of range b/w "+low+" and "+high+" is --> "+ traversal.rangeSumBST(traversal.root, low, high));
        System.out.println("Average of Nodes at each level: "+traversal.avgValueOfNodesAtEachLevel(traversal.root));
        System.out.println("Minimum Depth of BST: "+traversal.nodeWithMinimumDepth(traversal.root));
        System.out.println("Path Sum exist: "+traversal.pathSum(traversal.root, 39));
        System.out.println(traversal.isSameTreeUsingInorder(traversal.root, traversal.root));
        System.out.println("Zigzag traversal list: "+ traversal.zigZagTraversal(traversal.root));

        System.out.println("Right View: "+ traversal.rightView(traversal.root));

    }
}
