package leetcode150.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstaAlgo {
    public int getVertices() {
        return vertices;
    }

    public List<Edge>[] getAdjList() {
        return adjList;
    }

    private int vertices;
    private List<Edge>[] adjList;

    static class Edge {
        private int source;

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        private int destination;
        private int weight;

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }



        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public DijkstaAlgo(int vertices) {
        this.vertices = vertices;
        this.adjList = new List[vertices];
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
        DijkstaAlgo graph = new DijkstaAlgo(5);


        graph.addEdge(0,1, 6);
        graph.addEdge(0,2, 4);
        graph.addEdge(1,2, 1);
        graph.addEdge(1,3, 8);
        graph.addEdge(2,4, 7);

        graph.printGraph();

        System.out.println(graph.shortestPath(graph, 0));
    }

    // Need to re-visit
    // Explanation: https://www.youtube.com/watch?v=95-Ga-1UQvw&list=PLFdAYMIVJQHNFJQt2eWA9Sx3R5eF32WPn&index=12
    public int[] shortestPath(DijkstaAlgo graph, int source) {
        int[] distance = new int[graph.getAdjList().length];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        distance[source] = 0;
        queue.add(new Edge(source, source, 0));


        while(!queue.isEmpty()) {
            Edge curEdge = queue.poll();

            int destination = curEdge.getDestination();

            for(Edge edge: graph.getAdjList()[destination]) {
                int newDistance = distance[destination]+ edge.getWeight();

                if(newDistance < distance[edge.getDestination()]) {
                    distance[destination] = newDistance;
                    queue.add(new Edge(edge.getSource(), edge.getDestination(), newDistance));
                }
            }
        }
        return distance;
    }
}
