import java.util.HashSet;

/**
 * Give a range, min to max.
 * return the keys between the range.
 */
public class RangeSearch {
    private Label min, max;
    public Set<Label> inRange;

    public rangeFind(Label min, Label max) {
        this.min = min;
        this.max = max;
        inRange = new HashSet<Label>();
    }

    void action(Tree<Label> T){
        if (T.labe <= max && T.lael >= min) {
            inRange.add(T.label);
        }
    }

    /**
     * Prunning: restricting search to only nodes that might contain the answers we seek.
     * for example:
     *        6
     *      5    8
     *    3  4  7  9
     * When search range(6,8), don't need to search entire tree, just search 6's right.
     */
}
