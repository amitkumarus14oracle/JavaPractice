package daily.five.data.structure.questions.twenty.may.twenty;

import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    public char label;
    public boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }
}

public class GraphBFSImpl {
    private final int maxVertex = 20;
    private int[][] adjMatrix;
    private Vertex[] vertices;
    private int vertexCount;
    private Queue<Integer> queue;

    public GraphBFSImpl() {
        adjMatrix = new int[maxVertex][maxVertex];
        vertices = new Vertex[maxVertex];
        vertexCount = 0;
        queue = new LinkedList<>();
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertices[v].label);
    }

    public void bfs() {
        queue.offer(0);
        vertices[0].visited = true;
        displayVertex(0);
        while(!queue.isEmpty()) {
            int qElem = queue.poll();
            int temp;
            while( (temp = getAdjUnvisitedVertex(qElem)) != -1) {
                vertices[temp].visited = true;
                displayVertex(temp);
                queue.offer(temp);
            }
        }
        for (int i=0; i<vertexCount; i++) {
            vertices[i].visited = false;
        }

    }

    public int getAdjUnvisitedVertex(int v) {
        for(int i=0; i<vertexCount; i++){
            if (adjMatrix[v][i] ==1 && vertices[i].visited == false) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GraphBFSImpl g = new GraphBFSImpl();
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
        g.bfs();
    }
}
