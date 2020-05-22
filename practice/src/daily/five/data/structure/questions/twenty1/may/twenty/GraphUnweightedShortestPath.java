package daily.five.data.structure.questions.twenty1.may.twenty;

import daily.five.data.structure.questions.CreateGraph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphUnweightedShortestPath {
    public static void main(String[] args) {
        CreateGraph g = CreateGraph.getDefaultGraph();
        shortestPath(g, 0);
    }

    private static void shortestPath(CreateGraph g, int s) {
        Queue<Integer> q = new LinkedList<>();
        int vertexCount = g.getVertexCount();
        int distance[] = new int[vertexCount];
        q.offer(s);
        for(int i=0; i< vertexCount; i++) {
            distance[i] = -1;
        }
        distance[s] = 0;
        g.setVertexVisit(g.getVertices()[s],true);
        while(!q.isEmpty()) {
            int x = q.poll();
            int y;
            while((y = g.getAdjacentVertex(x)) != -1) {
                distance[y] = distance[x]+1;
                g.setVertexVisit(g.getVertices()[y],true);
                q.offer(y);
            }
        }
        System.out.println("Node distance index wise");
        int i =0;
        for (int d : distance) {
            System.out.println(g.getVertexLabel(g.getVertices()[i++])+ "th vertex has distance "+d);
        }
    }
}
