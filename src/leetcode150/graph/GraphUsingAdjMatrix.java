package leetcode150.graph;

public class GraphUsingAdjMatrix {
    private int vertices;
    private int[][] adjMatrix;

    public GraphUsingAdjMatrix(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1;
        adjMatrix[destination][source] = 1;
    }

    public void removeEdge(int source, int destination) {
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }

    public void removeVertex(int vertex) {
        int[][] newMatrix = new int[vertices-1][vertices-1];

        for(int i=0; i<newMatrix.length; i++) {
            for(int j=0; j<newMatrix.length; j++) {
                if(i != vertex || j != vertex)
                    newMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newMatrix;
        vertices--;
    }

    public void addVertex() {
        int[][] newMatrix = new int[vertices+1][vertices+1];

        int existingLen = adjMatrix.length;

        for(int i=0; i<existingLen; i++) {
            for(int j=0; j<existingLen; j++) {
                newMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newMatrix;
        vertices++;
    }

    public void printGraph() {
        for(int i=0; i<adjMatrix.length; i++) {
            for(int j=0; j<adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphUsingAdjMatrix graph = new GraphUsingAdjMatrix(5);
        graph.printGraph();
        System.out.println("**** After adding edges ******");
        graph.addEdge(1, 2);
        graph.addEdge(4, 3);System.out.println("**********");
        graph.addEdge(2, 4);

        graph.printGraph();

    }

}
