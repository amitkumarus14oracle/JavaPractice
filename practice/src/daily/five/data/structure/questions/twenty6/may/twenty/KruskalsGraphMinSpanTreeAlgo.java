package daily.five.data.structure.questions.twenty6.may.twenty;

import java.util.Arrays;

public class KruskalsGraphMinSpanTreeAlgo {

    private int vCount;
    private int eCount;
    private Edge[] edges;

    class Edge implements Comparable<Edge>, Cloneable {
        private int weight;
        private int src;
        private int dest;

        public Edge(int weight, int src, int dest) {
            this.weight = weight;
            this.src = src;
            this.dest = dest;
        }

        public Edge() {
        }

        public Edge clone() throws CloneNotSupportedException {
            return (Edge)super.clone();
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight < o.weight)
                return -1;
            else return 1;
        }
    }

    public KruskalsGraphMinSpanTreeAlgo(int vCount, int eCount) {
        this.vCount = vCount;
        this.eCount = eCount;
        edges = new Edge[eCount];
        for(int i=0; i<eCount; i++) {
            edges[i] = new Edge();
        }
    }

    public static void main(String[] args) {
        KruskalsGraphMinSpanTreeAlgo g = new KruskalsGraphMinSpanTreeAlgo(7,11);

        g.edges[0].src = 0;
        g.edges[0].dest = 2;
        g.edges[0].weight = 7;

        g.edges[1].src = 1;
        g.edges[1].dest = 2;
        g.edges[1].weight = 8;

        g.edges[2].src = 0;
        g.edges[2].dest = 3;
        g.edges[2].weight = 5;

        g.edges[3].src = 3;
        g.edges[3].dest = 4;
        g.edges[3].weight = 15;

        g.edges[4].src = 2;
        g.edges[4].dest = 3;
        g.edges[4].weight = 9;

        g.edges[5].src = 2;
        g.edges[5].dest = 4;
        g.edges[5].weight = 7;

        g.edges[6].src = 3;
        g.edges[6].dest = 5;
        g.edges[6].weight = 6;

        g.edges[7].src = 4;
        g.edges[7].dest = 5;
        g.edges[7].weight = 8;

        g.edges[8].src = 4;
        g.edges[8].dest = 6;
        g.edges[8].weight = 9;

        g.edges[9].src = 6;
        g.edges[9].dest = 5;
        g.edges[9].weight = 11;

        g.edges[10].src = 1;
        g.edges[10].dest = 4;
        g.edges[10].weight = 5;

        Arrays.sort(g.edges);
        Edge[] result = new Edge[g.vCount-1];
        int j =0;
        for(int i=0; i<g.edges.length; i++) {
            try {
                if(j<g.vCount-1) {
                    result[j] = g.edges[i].clone();
                    if(g.isCycle(result, j+1) == 0) {
                        j++;
                    }
                }

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        for (int i=0; i<result.length; i++) {
            System.out.println(result[i].src + " - "+ result[i].dest+ " - "+ result[i].weight  );
        }

    }

    public int findParent(int parents[], int x) {
        if(parents[x] == -1) {
            return x;
        }
        return findParent(parents, parents[x]);
    }

    public void union(int parents[], int x, int y) {
        int xParent = findParent(parents, x);
        int yParent = findParent(parents, y);
        parents[xParent] = yParent;
    }

    public int isCycle(Edge[] edges, int size) {
        int parents[] = new int[vCount];
        for(int i=0; i<vCount; i++) {
            parents[i] = -1;
        }
        for (int i=0; i<size; i++) {
            int xSet = findParent(parents, edges[i].src);
            int ySet = findParent(parents, edges[i].dest);

            if(xSet == ySet) {
                return 1;
            }
            union(parents, xSet, ySet);
        }
        return 0;
    }
}

