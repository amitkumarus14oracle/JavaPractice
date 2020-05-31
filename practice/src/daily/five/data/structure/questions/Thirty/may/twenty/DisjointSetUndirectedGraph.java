package daily.five.data.structure.questions.Thirty.may.twenty;

public class DisjointSetUndirectedGraph {
    private int vCount;
    private int eCount;
    private Edge[] edges;

    class Edge {
        int weight;
        int src;
        int dest;
    }

    public DisjointSetUndirectedGraph(int vCount, int eCount) {
        this.vCount = vCount;
        this.eCount = eCount;
        edges = new Edge[eCount];
        for (int i=0; i<eCount; i++) {
            edges[i] = new Edge();
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

    public int isCycle() {
        int parents[] = new int[vCount];
        for(int i=0; i<vCount; i++) {
            parents[i] = -1;
        }
        for (int i=0; i<eCount; i++) {
            int xSet = findParent(parents, edges[i].src);
            int ySet = findParent(parents, edges[i].dest);

            if(xSet == ySet) {
                return 1;
            }
            union(parents, xSet, ySet);
        }
        return 0;
    }

    public static void main(String[] args) {
        DisjointSetUndirectedGraph g = new DisjointSetUndirectedGraph(3,2);
        g.edges[0].src = 0;
        g.edges[0].dest = 1;

        g.edges[1].src = 1;
        g.edges[1].dest = 2;

        //g.edges[2].src = 0;
        //g.edges[2].dest = 2;

        if(g.isCycle() == 1) {
            System.out.println("graph has cycle");
        } else {
            System.out.println("graph has no cycle");
        }
    }
}
