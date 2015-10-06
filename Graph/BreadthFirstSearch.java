
public class BreadthFirstSearch implements PathSearch{

    private boolean[] marked;
    private int edgeTo[];
    private int s;    
    
    
    public BreadthFirstSearch(Graph G, int s){
	this.s = s;
	marked = new boolean[G.V()];
	edgeTo = new int[G.V()];
	bfs(G, s);
    }
    
    private void bfs(Graph G, int s){
	Queue<Integer> queue = new Queue<>();
	queue.enqueue(s);
	marked[s] = true;
	while(!queue.isEmpty()){
	    int v = queue.dequeue();
	    for(int w : G.adj(v)){
		if(marked[w] == false){
		    queue.enqueue(w);
		    marked[w] = true;
		    edgeTo[w] = v;
		}
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
    
    
    	
}
