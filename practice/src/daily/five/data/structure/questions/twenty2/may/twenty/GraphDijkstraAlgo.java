package daily.five.data.structure.questions.twenty2.may.twenty;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphDijkstraAlgo {
    public static void main(String[] args) {
        WeightGraph g = WeightGraph.createDefaultWeightedGraph();
        int[] distance = getShortestPath(g,0);
        for ( int d: distance) {
            System.out.println(d);
        }

    }

    private static int[] getShortestPath(WeightGraph g, int src) {
        PriorityQueue<PQNode> pq = new PriorityQueue<>();
        int distance[] = new int[g.getVertexCount()];
        for(int i=0; i<distance.length; i++) {
            distance[i] = -1;
        }
        distance[src] = 0;
        pq.offer(new PQNode(src, distance[src]));
        g.getVertices()[src].setVisited(true);
        while(!pq.isEmpty()) {
            int v = pq.poll().getvIndex();
            LinkedList<Integer> adjVertex = g.getAdjVertex(v);
            // get all the neighbours of v
            for(int w : adjVertex) {
                int dist = distance[v] + g.getAdjMatrix()[v][w];
                if(distance[w] == -1 ) {
                    distance[w] = dist;
                    pq.offer(new PQNode(w, dist));
                }
                if(distance[w] > dist) {
                    distance[w] = dist;
                    final int x = w;
                    PQNode update = pq.stream().filter(e -> e.getvIndex()== x).findFirst().get();
                    update.setDistance(dist);
                }
            }

        }
        return distance;
    }

}
class PQNode implements Comparable {
    private int vIndex;
    private int distance;

    public PQNode(int vIndex, int distance) {
        this.vIndex = vIndex;
        this.distance = distance;
    }

    public int getvIndex() {
        return vIndex;
    }

    public void setvIndex(int vIndex) {
        this.vIndex = vIndex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Object o) {
        PQNode n = (PQNode)o;
        if(this.distance < n.distance)
            return -1;
        if(this.distance > n.distance)
            return 1;
        return 0;
    }
}

class MyComparator<Integer> implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
class WeightGraph {
    private final int MAX_VERTEX = 20;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int vertexCount;

    public WeightGraph() {
        vertices = new Vertex[MAX_VERTEX];
        adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        vertexCount = 0;
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
    }

    public int getUnvisitedAdjVertex(int v) {
        for(int i=0; i<vertexCount; i++) {
            if(adjMatrix[v][i] != 0 && !(vertices[i].isVisited())) {
                return i;
            }
        }
        return -1;
    }

    public LinkedList<Integer> getAdjVertex(int v) {
        LinkedList<Integer> adjVertex = new LinkedList<>();
        for(int i=0; i<vertexCount; i++) {
            if(adjMatrix[v][i] != 0 && !(vertices[i].isVisited())) {
                adjVertex.add(i);
            }
        }
        return adjVertex;
    }

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

    public static WeightGraph createDefaultWeightedGraph() {
        WeightGraph g = new WeightGraph();
        g.addVertex('A');
        g.addVertex('A');
        g.addVertex('A');
        g.addVertex('A');
        g.addVertex('A');
        g.addEdge(0,1,4);
        g.addEdge(1,4,4);
        g.addEdge(0,2,1);
        g.addEdge(2,1,2);
        g.addEdge(2,3,4);
        g.addEdge(3,4,4);
        return g;
    }

}
class Vertex {
    private char label;
    private boolean visited;

    public Vertex(char label) {
        this.label = label;
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
