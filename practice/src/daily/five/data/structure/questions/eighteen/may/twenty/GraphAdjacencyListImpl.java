package daily.five.data.structure.questions.eighteen.may.twenty;

import java.util.ArrayList;

public class GraphAdjacencyListImpl {
    private ArrayList<Integer> vertices;
    private Node[] edges;
    private int vertexCount;

    public GraphAdjacencyListImpl() {
    }

    public GraphAdjacencyListImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertices = new ArrayList<>();
        this.edges = new Node[vertexCount];
        for(int i=0; i<vertexCount; i++) {
            vertices.add(i);
            edges[i] = null; // there would be no edge at the begining
        }
    }

    public void addEdge(int source, int dest) {
        int srcIndex = vertices.indexOf(source);
        int destIndex = vertices.indexOf(dest);
        if(srcIndex != -1 && destIndex != -1) {
            if(edges[srcIndex] == null) {
                edges[srcIndex] = new Node(dest);
            } else {
                Node newNode = new Node(dest);
                newNode.setNext(edges[srcIndex]);
                edges[srcIndex] = newNode;
            }
            if(edges[destIndex] == null) {
                edges[destIndex] = new Node(source);
            } else {
                Node newNode = new Node(source);
                newNode.setNext(edges[destIndex]);
                edges[destIndex] = newNode;
            }
        }
    }

    public void printEdgeList() {
        for(Node list: edges) {
            Node.printNodeList(list);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyListImpl g = new GraphAdjacencyListImpl(3);
        g.addEdge(0,2);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.printEdgeList();
    }
}
