package ds.graph;

import java.util.*;

public class GraphUsingList {
    private Map<Integer, List<Integer>> adjList;

    public GraphUsingList() {
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjList.put(vertex, new LinkedList<>());
    }

    public void removeVertex(int vertex) {
        adjList.remove(vertex);
        for(List<Integer> list: adjList.values()) {
            list.remove((Integer) vertex);
        }
    }

    public void addEdges(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void removeEdges(int source, int destination) {
        adjList.get(source).remove((Integer) destination);
        adjList.get(destination).remove((Integer) source);
    }

    public void iterativeDFS(int vertex) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedSet = new HashSet<>();

        stack.push(vertex);

        while(!stack.isEmpty()) {

            int currentVertex = stack.pop();

            System.out.print(currentVertex+" ");
            visitedSet.add(currentVertex);

            for(int neighbor: adjList.getOrDefault(currentVertex, Collections.emptyList())) {
                if(!visitedSet.contains(neighbor))
                    stack.push(neighbor);
            }
        }
    }
}
