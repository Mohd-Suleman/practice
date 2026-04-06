package ds.graph;


public class InitialGraph {
    private int[][] adjMatrix;
    private int vertices;

    public InitialGraph(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }

    public void printGraph() {
        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void addEdges(int source, int destination, int weight) {
        adjMatrix[source][destination] = weight;
        adjMatrix[destination][source] = weight;
    }

    public void removeEdges(int source, int destination) {
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }



    public void addNewVertex() {
        int[][] newMatrix = new int[vertices+1][vertices+1];
        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++){
                newMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newMatrix;
        vertices++;
    }

    public static void main(String[] args) {
        InitialGraph graph = new InitialGraph(4);
        graph.printGraph();

        System.out.println("Adding Edge");
        graph.addEdges(2,3, 1);
        graph.printGraph();

        System.out.println("Remove Edge");
        graph.removeEdges(2,3);
        graph.printGraph();

        System.out.println("Adding Vertex");
        graph.addNewVertex();
        graph.printGraph();
    }
}
