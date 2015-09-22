
public interface MaxPQ<Key> {

	void insert(Key key);

	Key max();

	Key delMax();

	boolean isEmpty();

	int size();

}
