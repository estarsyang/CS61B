/**
 * (Min) priority Queue: allowing tracking and removal of the smallest item in a priority queue.
 * @param <Item> any type what u want
 */
public interface MinPQ<Item> {
    /** Adds the item to the priority queue. */
    public void add();

    /** Return the smallest item in the priority queue. */
    public Item getSmallest();

    /** Removes the smallest item from the priority queue. */
    public Item removeSmallest();

    /** return the size of the priority queue. */
    public int size();
}
