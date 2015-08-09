
import java.util.Arrays;

public class WeightedPCQuickUnionUF implements UnionFind{

	private int[] id;
	private int[] sz;

	public WeightedPCQuickUnionUF(int N){
		id = new int[N];
		sz = new int[N];
		for(int i = 0; i<id.length ; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) {

		if(id[i] == i){
			return i;
		}
		
		int root =  root(id[i]);
		id[i] = root;
		return root;
	}
	
	@Override
	public void union(int p, int q) {
		//change p's root to point to q's root
		int rootP = root(p);
		int rootQ = root(q);
		if(rootP == rootQ){
			return;
		}
		
		if(sz[rootP] > sz[rootQ]){
			id[rootQ] = rootP;	
			sz[rootP] += sz[rootQ]; 
		} else{
			id[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
		}
				
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return (root(p) == root(q));
	}
	
	public static void main(String[] args){
		WeightedPCQuickUnionUF uf = new WeightedPCQuickUnionUF(10);
	    uf.union(4, 3);
	    uf.union(3, 8);
	    uf.union(6, 5);
	    uf.union(9, 4);
	    uf.union(2, 1);
	    uf.union(8, 9);
	    uf.union(5, 0);
	    uf.union(6, 1);
	    uf.union(1, 0);
	    uf.union(6, 7);
	    StdOut.println(Arrays.toString(uf.id));
	}
}
