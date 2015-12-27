import java.util.Arrays;

public class QuickFindUF implements UnionFind{

	private int[] id;

	public QuickFindUF(int N){
		id = new int[N];
		for(int i = 0; i<id.length ; i++){
			id[i] = i; 
		}
	}
	
	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++){
			if (id[i] == pid){
				id[i] = qid;
			}
		}
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return id[p] == id[q];
	}
	
	public static void main(String[] args){
	    QuickFindUF uf = new QuickFindUF(10);
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
	    System.out.println(Arrays.toString(uf.id));
	}
	
}