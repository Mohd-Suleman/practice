package leetcode150.graph;

import java.util.*;

public class MinimumSpanningTree {
    private int vertices;

    private List<Edge>[] adjList;

    static class Edge {
        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        private int source;
        private int destination;
        private int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public MinimumSpanningTree(int vertices) {
        this.vertices = vertices;
        adjList = new List[vertices];
        for(int i=0; i<vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge fwdEdge = new Edge(source, destination, weight);
        Edge bckEdge = new Edge(destination, source, weight);

        adjList[source].add(fwdEdge);
        adjList[destination].add(bckEdge);

    }


    public void printGraph() {
        for(int i=0; i<adjList.length; i++) {
            System.out.println("Node " +adjList[i]);
        }
    }

    public static void main(String[] args) {
        MinimumSpanningTree graph = new MinimumSpanningTree(5);

        graph.addEdge(0,1, 6);
        graph.addEdge(0,2, 4);
        graph.addEdge(1,2, 1);
        graph.addEdge(1,3, 8);
        graph.addEdge(2,4, 7);

        graph.printGraph();

        System.out.println("MST --> ");
        System.out.println(graph.minimumSpanningTree(graph));
    }


    // MSTT Usingg Prism Algo
    // Explanation: https://www.youtube.com/watch?v=y40TOm0Hnys&list=PLFdAYMIVJQHNFJQt2eWA9Sx3R5eF32WPn&index=9
    // Greedy for minimum vertices
    public List<Edge> minimumSpanningTree(MinimumSpanningTree graph) {
        List<Edge>[] vertices = graph.adjList;

        boolean[] inMST = new boolean[vertices.length];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        List<Edge> result = new ArrayList<>();

        int startVertx = 0;
        inMST[startVertx] = true;

        priorityQueue.addAll(vertices[startVertx]);

        while(!priorityQueue.isEmpty()) {
            Edge curEdge = priorityQueue.poll();

            int destination = curEdge.getDestination();
            if(inMST[destination]) continue;

            result.add(curEdge);
            inMST[destination] = true;

            priorityQueue.addAll(vertices[destination]);
        }
        return result;

    }
}
