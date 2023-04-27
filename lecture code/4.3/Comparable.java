/**
 * negative if this less than obj
 * 0 if this is equal to obj
 * positive if this is greater than obj.
 */
public interface Comparable<T> {
    public int compareTo(T obj);
}
