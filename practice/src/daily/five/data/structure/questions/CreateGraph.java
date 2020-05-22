package daily.five.data.structure.questions;

import java.util.Stack;

public class CreateGraph {
    private final int MAX_VERTEX_COUNT = 20;
    private int adjMatrix[][];
    private Vertex[] vertices;
    private Stack<Integer> stack;
    private int vertexCount;

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public void setVertexVisit(Vertex vertex, boolean visited) {
        vertex.setVisited(visited);
    }

    public char getVertexLabel(Vertex vertex) {
        return vertex.getLabel();
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public CreateGraph() {
        vertices = new Vertex[MAX_VERTEX_COUNT];
        adjMatrix = new int[MAX_VERTEX_COUNT][MAX_VERTEX_COUNT];
        stack = new Stack<>();
        vertexCount = 0;
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
       // adjMatrix[dest][src] = 1; // uncomment this in case of undirected graph
    }

    public void displayVertex(Vertex v) {
        System.out.println(v.getLabel());
    }
    public void displayVertex(int v) {
        System.out.println(vertices[v].getLabel());
    }


    public int getAdjacentVertex(int v) {
        for(int i=0; i<adjMatrix.length; i++) {
            if(adjMatrix[v][i]==1 && !vertices[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CreateGraph g = getDefaultGraph();
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public static CreateGraph getDefaultGraph() {
        CreateGraph g = new CreateGraph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2,4);
        g.addEdge(3,5);
        return g;
    }

}

class Vertex {
    private char label;
    private boolean visited;
    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}