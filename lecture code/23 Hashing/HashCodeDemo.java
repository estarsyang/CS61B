import java.sql.Array;

/**
 * BST is very fast, but it has some limitation;
 * - Items must be comparable
 * - Maintaining bushiness is not easy.
 * - Big-Theta(log N) is good, can do better.
 * There are some cases for storing data in the life,
 * - unordered array, get, contains, worst case runtimes is Θ(n)
 * - ...
 * so, using bit to represent all data.
 * for example, boolean array list, 0, DataIndexedArray[0] = true, 5, DataIndexedArray[5] = true,..., so on.
 * DataIndexedArray. get worst case runtimes is Θ(1)
 */
public class HashCodeDemo {
    public class DataIndexedIntegerSet{
        boolean[] present;

        /**
         * whatever n is larger, worse case runtime always is Θ(1);
         * @param n
         */

        public DataIndexedIntegerSet(int n) {
            present = new boolean[n];
        }

        public void insert(int i){
            present[i] = true;
        }

        public boolean contains(int i) {
            return present[i];
        }
    }
    /**
     * but array's maximum length is constant. Actual value must exceed this size.
     * so one ith item must store multiple data.
     * problems:
     * - one ith item need to do collision handling
     *      - using External chaining
     * - how to convert arbitrary data to an index.
     *      - using hashCode to get an index
     */

    /**
     * all object has one method named hashCode. you can override it.
     * Below function is just a simple case, not really Object's hashCode method.
     * @return
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        for (Object o: this){ // just one pseudocode
            hashCode = hashCode * 31; // why * 31, base on your digital number is base 2, 8, 10, 16 or 32.
            hashCode = hashCode + o.hashCode();
        }
        return hashCode;
    }
}
