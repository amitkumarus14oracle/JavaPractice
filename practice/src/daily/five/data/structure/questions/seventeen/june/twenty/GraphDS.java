package daily.five.data.structure.questions.seventeen.june.twenty;

import java.util.Stack;

public class GraphDS {
    final int MAX_VERTEX = 20;
    private int[][] adjMatrix;
    private Vertex[] vertices;
    private int verCount;

    public GraphDS() {
        this.adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        this.vertices = new Vertex[MAX_VERTEX];
    }

    public void addVertex(char label) {
        vertices[verCount++] = new Vertex(label);
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public int getVerCount() {
        return verCount;
    }

    public void setVerCount(int verCount) {
        this.verCount = verCount;
    }

    public int getUnvisitedAdjVertex(int ver) {
        for(int i=0; i<verCount; i++) {
            if(adjMatrix[ver][i] == 1 && !vertices[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    public void graphVisit(int pos) {
        Stack<Integer> s = new Stack<>();
        s.push(pos);
        while(!s.isEmpty()) {
            int t = s.pop();
            vertices[t].setVisited(true);
            System.out.println(vertices[t].getLabel());
            int d = getUnvisitedAdjVertex(t);
            if(d != -1) {
                //vertices[d]
                s.push(d);
            }
        }
    }

    public static void main(String[] args) {
        GraphDS g = new GraphDS();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(0,4);
        g.graphVisit(0);

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