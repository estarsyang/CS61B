import java.util.List;

public interface Map61B<K,V> {
    public boolean containKey(K key);
    public void put(K key, V value);
    public V get(K key);
    public List<K> keys();
}
