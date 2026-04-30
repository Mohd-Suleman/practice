package leetcode150.graph;

import java.util.*;

public class CloneGraph {

    static class Node {
        private int value;
        private List<Node> neighbor;

        Node(int value) {
            this.value = value;
            this.neighbor = new ArrayList<>();
        }

        Node() {
            this.value = 0;
            this.neighbor = new ArrayList<>();
        }

        Node(int value, List<Node> neighbor) {
            this.value = value;
            this.neighbor = neighbor;
        }
    }

    /**
     * Explanation: https://www.youtube.com/watch?v=Nki9V1tD5_I
     * */
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        return cloneHelper(node, map);
    }
    private Node cloneHelper(Node node, Map<Node, Node> map) {
        Node newNode = new Node(node.value);
        map.put(node, newNode);

        for(Node neighbor: node.neighbor) {
            if(!map.containsKey(neighbor)) {
                newNode.neighbor.add(cloneHelper(neighbor, map));
            } else {
                newNode.neighbor.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}
