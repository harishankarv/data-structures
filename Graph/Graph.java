public class Graph {

    private final int V;
    private int E;

    /* Bag represents a set which allows duplicates (multiset) */
    private Bag<Integer>[] adj; // internally uses a linked list

    public Graph(int V) {
	this.V = V;
	this.E = 0;
	adj = (Bag<Integer>[]) new Bag[V];
	for (int i = 0; i < V; i++) {
	    adj[i] = new Bag<Integer>();
	}
    }

    public void addEdge(int v, int w) {
	adj[v].add(w);
	adj[w].add(v);
	E++;
    }

    public Iterable<Integer> adj(int v) {
	return adj[v];
    }

    // number of vertices
    public int V() {
	return this.V;
    }

    // number of edges
    public int E() {
	return this.E;
    }
    
}
