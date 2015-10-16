
public interface MinPQ<Key> {

	void insert(Key key);

	Key min();

	Key delMin();

	boolean isEmpty();

	int size();

}
