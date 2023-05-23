public interface Tree<K,V> {
    public V searchKey(K key);
    public Tree insert(K key);
}
