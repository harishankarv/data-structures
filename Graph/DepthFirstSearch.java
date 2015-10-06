public class DepthFirstSearch implements PathSearch {

    private boolean[] marked;
    private int edgeTo[];
    private int s;
    /*
     * no need to store Graph G, as we don't need G after constructor's work is
     * done, to implement our API.
     */

    public DepthFirstSearch(Graph G, int s) {
	this.s = s;
	edgeTo = new int[G.V()];
	marked = new boolean[G.V()];
	dfs(G, s);
    }

    private void dfsIterative(Graph G, int s) {
	Stack<Integer> stack = new Stack<>();
	stack.push(s);
	while (!stack.isEmpty()) {
	    int v = stack.pop();
	    if (!marked[v]) {
		marked[v] = true;
		for (int w : G.adj(v)) {
		    if (!marked[w]) {
			stack.push(w);
			edgeTo[w] = v;
		    }
		}
	    }
	}
    }

    private void dfs(Graph G, int v) {
	marked[v] = true;
	for (int w : G.adj(v)) {
	    if (marked[w] == false) {
		edgeTo[w] = v;
		dfs(G, w);
	    }
	}
    }

    public boolean hasPathTo(int v) {
	return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
	if (hasPathTo(v) == false)
	    return null;
	Stack<Integer> stack = new Stack<>();
	for (int i = v; i != s; i = edgeTo[i]) {
	    stack.push(i);
	}
	stack.push(s);
	return stack;
    }

    public static void main(String[] args) {
	Graph G = new Graph(4);
	G.addEdge(0, 1);
	G.addEdge(0, 2);
	G.addEdge(1, 2);
	G.addEdge(1, 3);
	int s = 0;
	DepthFirstSearch dfs = new DepthFirstSearch(G, s);

	for (int v = 0; v < G.V(); v++) {
	    if (dfs.hasPathTo(v)) {
		StdOut.printf("%d to %d:  ", s, v);
		for (int x : dfs.pathTo(v)) {
		    if (x == s)
			StdOut.print(x);
		    else
			StdOut.print("-" + x);
		}
		StdOut.println();
	    }

	    else {
		StdOut.printf("%d to %d:  not connected\n", s, v);
	    }

	}
    }

}
