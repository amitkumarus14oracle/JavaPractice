package daily.five.data.structure.questions.twenty5.may.twenty;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphPrimsAlgo {
    public static void main(String[] args) {
        Graph g = Graph.getDefaultGraph();
        int[] distance = prismMinSpanTreeCost(g, 0);
        System.out.println();
        for (int d: distance) {
            System.out.println(d);
        }

    }

    public static int[] prismMinSpanTreeCost(Graph g, int src) {
        PriorityQueue<PQNode> pq = new PriorityQueue<>();
        int distance[] = new int[g.getVertexCount()];
        int path[] = new int[g.getVertexCount()];
        for(int i=0; i<distance.length; i++) {
            distance[i] = -1;
            path[i] = -1;
        }
        distance[src] = 0;
        pq.offer(new PQNode(src, distance[src]));
        while(!pq.isEmpty()) {
            int v = pq.poll().getvIndex();
            g.getVertices()[v].setVisited(true);
            LinkedList<Integer> adjW = g.getAdjacentNodes(v);
            for (int w: adjW) {
                int dist = /*distance[v]+ */g.getAdjMatrix()[v][w];
                if(distance[w] == -1) {
                    distance[w] = g.getAdjMatrix()[v][w];
                    pq.offer(new PQNode(w, distance[w]));
                    path[w] = v;
                }
                if(distance[w] > dist) {
                    distance[w] = g.getAdjMatrix()[v][w];
                    pq.stream().filter(e-> e.getvIndex()==w).findFirst().get().setCost(dist);
                    path[w] =v;
                }

            }
        }
        printSolution(src, distance, path);
        //System.out.print(src+ " ");
        //printPath(6, path);
        return distance;
    }
    private static void printPath(int currentVertex,
                                  int[] parents)
    {
        // Base case : Source node has
        // been processed
        if (parents[currentVertex] == -1)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    private static void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            if (vertexIndex != startVertex)
            {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                System.out.print(startVertex+" ");
                printPath(vertexIndex, parents);
            }
        }
    }
}
class PQNode implements Comparable{
    private int vIndex;
    private int cost;

    public PQNode(int vIndex, int cost) {
        this.vIndex = vIndex;
        this.cost = cost;
    }

    public int getvIndex() {
        return vIndex;
    }

    public void setvIndex(int vIndex) {
        this.vIndex = vIndex;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        PQNode node = (PQNode)o;
        if(this.cost < node.cost) {
            return -1;
        }
        if(this.cost > node.cost) {
            return 1;
        }
        return 0;
    }
}

class Graph {
    private final int MAX_VERTEX_COUNT = 20;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int vertexCount;

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public Graph() {
        this.vertices = new Vertex[MAX_VERTEX_COUNT];
        this.adjMatrix = new int[MAX_VERTEX_COUNT][MAX_VERTEX_COUNT];
        vertexCount = 0;
    }

    public void addVertex(char c) {
        vertices[vertexCount++] = new Vertex(c);
    }

    public void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight;
    }

    public static Graph getDefaultGraph() {
        Graph g =new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');

        g.addEdge(0,2,7);
        g.addEdge(0,3,5);
        g.addEdge(1,2, 8);
        g.addEdge(1,4, 5);
        g.addEdge(2,3, 9);
        g.addEdge(2,4, 7);
        g.addEdge(3,4, 15);
        g.addEdge(3,5, 6);
        g.addEdge(4,5, 8);
        g.addEdge(4,6, 9);
        g.addEdge(5,6, 11);

        return g;
    }

    public LinkedList<Integer> getAdjacentNodes(int v) {
        LinkedList<Integer> adjNodes = new LinkedList<>();
        for(int i=0; i<vertexCount; i++) {
            if(adjMatrix[v][i]!=0 && !vertices[i].isVisited()) {
                adjNodes.add(i);
            }
        }
        return adjNodes;
    }
}

class Vertex {
    private char label;
    private boolean visited;

    public Vertex(char label) {
        this.label = label;
        visited = false;
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
