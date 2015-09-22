/*
 * A data structure for a graph.
 * Vertices are denoted as integers. 
 * (It is up to the client to use some mechanism for conversion 
 * from integer to type required for vertices, eg. using a symbol table)
 */

public class Graph {

    private final int V;
    private Bag<Integer>[] adj; /* array of adjecency lists for each vertex */

    /* constructor which accepts the number of vertices */
    public Graph(int V) {
	this.V = V;
	adj = (Bag<Integer>[]) new Bag[V];
	for (int i = 0; i < V; i++)
	    adj[i] = new Bag<Integer>();
    }
    
    public void addEdge(int v, int w) {
	adj[v].add(w);
	adj[w].add(v);
    }
    
    /*Iterate over all the vertices adjacent to given vertex*/
    public Iterable<Integer> adj(int v) {
	return adj[v];
    }

}
