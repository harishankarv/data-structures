
public interface UnionFind {

	void union(int p, int q); //add connection between p and q
	boolean connected(int p, int q); //are p and q in the same component?
	
}