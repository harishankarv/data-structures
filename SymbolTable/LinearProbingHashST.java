
public class LinearProbingHashST<Key, Value> implements SymbolTable<Key, Value> {

	private int M;
	private int p;
	private static final int[] PRIMES = { 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381, 32749, 65521,
			131071, 262139, 524287, 1048573, 2097143, 4194301, 8388593, 16777213, 33554393, 67108859, 134217689,
			268435399, 536870909, 1073741789, 2147483647 };
	private int N;
	private Key[] keys;
	private Value[] vals;

	public LinearProbingHashST() {
		p = 0;
		M = PRIMES[p++];
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}

	private int hash(Key key) {
		return key.hashCode() % M;
	}

	private void resize() {
		M = PRIMES[p];
		Key[] k = (Key[]) new Object[M];
		Value[] v = (Value[]) new Object[M];

		for (int i = 0; i < keys.length; i++) {
			k[i] = keys[i];
			v[i] = vals[i];
		}

		keys = k;
		vals = v;
	}

	@Override
	public void put(Key key, Value val) {
		if (N == keys.length / 2) { // resize if half full
			p++;
			resize();
		} 
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key))
				break;
			i = (i + 1) % M;
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	@Override
	public Value get(Key key) {
				int i = hash(key);
		while (keys[i] != null) {
			if (key.equals(keys[i]))
				return vals[i];
			i = (i + 1) % M;
		}
		return null;
	}

	@Override
	public void delete(Key key) {
		if (N == keys.length / 4) { // resize if quarter full
			p--;
			resize();
		} 
		int i = hash(key);
		while(keys[i] != null){
			if(key.equals(keys[i]))
				break;
			i = (i + 1) % M;
		}
		keys[i] = null;
		vals[i] = null;
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<>();
		for (Key k : keys)
			if (k != null)
				q.enqueue(k);
		return q;
	}

	public static void main(String[] args) {

		
		String filename = args[0];
		In in = new In(filename);

		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
		for (int i = 0; !in.isEmpty(); i++) {
			String key = in.readString();
			st.put(key, i);
		}

		st.delete("H");

		// print keys
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}
