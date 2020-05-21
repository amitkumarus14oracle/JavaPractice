package daily.five.data.structure.questions.nighteen.may.twenty;

import java.util.Stack;

public class GraphDFSImpl {
    private final int MAX_VERTEX_COUNT = 20;
    private int adjMatrix[][];
    private Vertex[] vertices;
    private Stack<Integer> stack;
    private int vertexCount;

    public GraphDFSImpl() {
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
        adjMatrix[dest][src] = 1;
    }

    public void displayVertex(Vertex v) {
        System.out.println(v.getLabel());
    }
    public void displayVertex(int v) {
        System.out.println(vertices[v].getLabel());
    }

    public void dfs() {
        vertices[0].setVisited(true);
        displayVertex(0);
        stack.push(0);
        while(!stack.isEmpty()) {
            int v = getAdjacentVertex(stack.peek());
            if(v == -1){
                stack.pop();
            } else {
                vertices[v].setVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i =0 ;i<vertexCount; i++) {
            vertices[i].setVisited(false);
        }
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
        GraphDFSImpl g = getDefaultGraph();
        g.dfs();
    }

    public static GraphDFSImpl getDefaultGraph() {
        GraphDFSImpl g = new GraphDFSImpl();
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