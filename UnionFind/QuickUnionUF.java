import java.util.Arrays;

public class QuickUnionUF implements UnionFind{

	private int[] id;

	public QuickUnionUF(int N){
		id = new int[N];
		for(int i = 0; i<id.length ; i++){
			id[i] = i; 
		}
	}
	
	private int root(int i) {
		if(id[i] == i){
			return i;
		}
		return root(id[i]);
	}
	@Override
	public void union(int p, int q) {
		//change p's root to point to q's root
		id[root(p)] = id[root(q)];		
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return (root(p) == root(q));
	}
	
	public static void main(String[] args){
		QuickUnionUF uf = new QuickUnionUF(10);
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
