
public class ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Graph G) {
	this.count = 0;
	marked = new boolean[G.V()];
	id = new int[G.V()];
	for (int i = 0; i < id.length; i++) {
	    if (!marked[i]) {
		dfs(G, i);
		count++;
	    }
	}
    }

    private void dfs(Graph G, int v) {
	marked[v] = true;
	id[v] = count;
	for (int w : G.adj(v)) {
	    if (!marked[w])
		dfs(G, w);
	}
    }

    public int count() {
	return count;
    }

    public int id(int v) {
	return id[v];
    }

    public boolean connected(int v, int w) {
	return id[v] == id[w];
    }

    public static void main(String[] args) {
	Graph G = new Graph(6);
	G.addEdge(0, 1);
	G.addEdge(0, 2);
	G.addEdge(1, 2);
	G.addEdge(1, 3);
	G.addEdge(4, 5);
	ConnectedComponents cc = new ConnectedComponents(G);

	// number of connected components
	int M = cc.count();
	StdOut.println(M + " components");

	// compute list of vertices in each connected component
	Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
	for (int i = 0; i < M; i++) {
	    components[i] = new Queue<Integer>();
	}
	for (int v = 0; v < G.V(); v++) {
	    components[cc.id(v)].enqueue(v);
	}

	// print results
	for (int i = 0; i < M; i++) {
	    for (int v : components[i]) {
		StdOut.print(v + " ");
	    }
	    StdOut.println();
	}
    }

}
