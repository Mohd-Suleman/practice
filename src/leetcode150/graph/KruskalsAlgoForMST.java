package leetcode150.graph;

import java.util.*;

public class KruskalsAlgoForMST {
    private int vertices;
    private List<Edge>[] adjList;

    static class Edge {
        int source;
        int destination;

        public int getWeight() {
            return weight;
        }

        public int getDestination() {
            return destination;
        }

        public int getSource() {
            return source;
        }

        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }

    public KruskalsAlgoForMST(int vertices) {
        this.vertices = vertices;
        adjList = new List[vertices];

        for(int i=0; i<vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    public void addEdge(int source, int destination, int weight) {
        Edge forwardEdge = new Edge(source, destination, weight);
        Edge backwardEdge = new Edge(destination, source, weight);

        adjList[source].add(forwardEdge);
        adjList[destination].add(backwardEdge);
    }

    public void printGraph() {
        for(int i=0; i<adjList.length; i++) {
            System.out.println("Node " +adjList[i]);
        }
    }

    public static void main(String[] args) {
        KruskalsAlgoForMST graph = new KruskalsAlgoForMST(5);

        graph.addEdge(0,1, 6);
        graph.addEdge(0,2, 4);
        graph.addEdge(1,2, 1);
        graph.addEdge(1,3, 8);
        graph.addEdge(2,4, 7);

        graph.printGraph();

        System.out.println(graph.findMST(graph));

    }

    // MSTT Usingg Prism Algo
    // Explanation: https://www.youtube.com/watch?v=_nJZVJp04cA&list=PLFdAYMIVJQHNFJQt2eWA9Sx3R5eF32WPn&index=11
    // Greedy for minimum Edges
    public List<Edge> findMST(KruskalsAlgoForMST graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        for(List<Edge> edges: graph.adjList) {
            queue.addAll(edges);
        }
        List<Edge> result = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();

        while(!queue.isEmpty()) {
            Edge curEdge = queue.poll();

            int source = curEdge.getSource();
            int destination = curEdge.getDestination();

            if(visitedSet.contains(source) && visitedSet.contains(destination))
                continue;

            result.add(curEdge);
            visitedSet.add(source);
            visitedSet.add(destination);
        }

        return result;
    }
}
