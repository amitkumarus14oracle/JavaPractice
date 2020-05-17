package daily.five.data.structure.questions.seventeen.may.twenty;

public class GraphImpl {
    private boolean adjMatrix[][];
    private int vertices;

    public GraphImpl(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new boolean[vertices][vertices];
    }

    public void addEdge(int src, int dest) {
        if(src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = true;
            adjMatrix[dest][src] = true;
        }
    }

    public void removeEdge(int src, int dest) {
        if(src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = false;
            adjMatrix[dest][src] = false;
        }
    }

    public boolean isEdge(int src, int dest) {
        if(src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            return adjMatrix[src][dest];
        }
        return false;
    }

    public static void main(String[] args) {
        GraphImpl g = new GraphImpl(4);
        g.addEdge(2,3);
        g.addEdge(1,3);
        g.addEdge(0,3);
        printArray(g.adjMatrix);
        g.removeEdge(3,0);
        printArray(g.adjMatrix);
        System.out.println(g.isEdge(0,3));
    }

    public static void printArray(boolean[][] mat) {
        for(boolean a[]: mat) {
            for (boolean b : a) {
                System.out.print(b+"\t");
            }
            System.out.println();
        }
    }
}
