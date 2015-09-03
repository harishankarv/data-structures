
public interface SymbolTable<Key, Value> {


	void put(Key key, Value val);// put key-value pair into the table (remove
									// key from table if value is null)

	Value get(Key key); // (null if key is absent)

	void delete(Key key); // remove key (and its value) from table

	boolean contains(Key key); // is there a value paired with key?

	boolean isEmpty(); // is the table empty?

	Iterable<Key> keys(); // all the keys in the table

}
