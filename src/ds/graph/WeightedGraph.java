package ds.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    private int vertices;
    private List<GraphEdges>[] adjList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList[vertices];
    for(int i=0; i<vertices;  i++)
        adjList[i] = new ArrayList<>();

    }

}
