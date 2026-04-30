package leetcode150.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    private int vertices;
    private List<Edge>[] edges;

    static class Edge {
        private int source;
        private int destination;
        private int weight;

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

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        edges = new List[vertices+1];
        for(int i=1; i<=vertices; i++) {
            edges[i] = new ArrayList<>();
        }
    }


    public void addUndirectedEdge(int source, int destination, int weight) {
        Edge forwardEdge = new Edge(source, destination, weight);
        Edge backwardEdge = new Edge(destination, source, weight);
        edges[source].add(forwardEdge);
        edges[destination].add(backwardEdge);
    }

    public void addDirectedEdge(int source, int destination, int weight) {
        Edge forwardEdge = new Edge(source, destination, weight);
        edges[source].add(forwardEdge);
    }

    public void printGraph() {

        for(int i=1; i<edges.length; i++) {
            for(Edge edge: edges[i]) {
                System.out.println(edge);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(4);
        graph.addUndirectedEdge(1,3,2);
        graph.addUndirectedEdge(2,4,1);
        graph.addUndirectedEdge(2,3,1);
        graph.addDirectedEdge(1,2,5);
        graph.printGraph();
    }
}
