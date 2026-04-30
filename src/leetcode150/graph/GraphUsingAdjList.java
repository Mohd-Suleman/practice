package leetcode150.graph;


import java.util.*;

public class GraphUsingAdjList {

    private Map<Integer, List<Integer>> adjList;

    public GraphUsingAdjList() {
        this.adjList = new HashMap<>();
    }

    public void addVertices(int numOfVertices) {
        for(int i=1; i<=numOfVertices; i++)
            adjList.put(i, new LinkedList<>());
    }

    public void addVertex(int vertex) {
        if(!adjList.containsKey(vertex))
            adjList.put(vertex, new LinkedList<>());
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    //Fix needed for IndexOutOfBoud
    // Autoboxing is the fix
    public void removeEdge(int source, int destination) {
        adjList.get(source).remove((Integer) destination);
        adjList.get(destination).remove((Integer)source);

    }

    public void removeVertex(int vertex) {
        if(!adjList.containsKey(vertex)) {
            System.out.println("Invalid Vertex...");
            return;
        }
        adjList.remove(vertex);
        for(List<Integer> list: adjList.values()){
            list.remove((Integer) vertex);
        }
    }

    public void iterativeDFS(int vertex) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            System.out.print(cur+" ");
            set.add(cur);

            for(int neighbor: adjList.getOrDefault(cur, Collections.emptyList())) {
                if(!set.contains(neighbor))
                    stack.push(neighbor);
            }
        }
        System.out.println();
    }

    public void iterativeBFS(int vertex) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            System.out.print(cur+" ");
            set.add(cur);

            for(int neighbor: adjList.getOrDefault(cur, Collections.emptyList())) {
                if(!set.contains(neighbor))
                    queue.offer(neighbor);
            }
        }
        System.out.println();
    }

    public void printGraph() {
        System.out.println(adjList);
    }

    public static void main(String[] args) {
        GraphUsingAdjList graph = new GraphUsingAdjList();

        graph.printGraph();
        System.out.println("**** Added Vertices ******");
        graph.addVertices(5);
        graph.printGraph();

        System.out.println("**** Added Vertices ******");

        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(5, 3);
        graph.addEdge(4, 2);

        graph.printGraph();

        System.out.println("Iterative DFS");
        graph.iterativeDFS(1);
        System.out.println("Iterative BFS");
        graph.iterativeBFS(1);


        System.out.println("**** Removed Edge ******");
        graph.removeEdge(5, 3);
        graph.printGraph();

        System.out.println("**** Removed Vertex ******");
        graph.removeVertex(4);
        graph.printGraph();
    }
}
