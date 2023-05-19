public class Hashing {

    public int hashCode1() {
        return -1;
        /**
         * valid, As required, this hash function returns the same hashCode for Integers that are equals()
         * to each other. However, this is a terrible hash code because collisions are extremely frequent.(100% of the
         * time
         */
    }

    public int hashCode2() {
        return intValue() * intValue();
        /**
         * valid. similar to (a), this hash function returns the same hashCode for integers that are equals().
         * However, integers that share the same absolute values will collide(x=5 and x=-5 will have the same hash
         * code). A better hash function would be to just return the intValue() itself.
         */
    }

    public int hashCode3() {
        return super.hashCode();
        /**
         * Invalid. this is not a valid hash function because integers that are equals to each other will not have
         * same hash code. Instead, this hash function returns some integer corresponding to the integer object's location
         * in memory.
         */
    }
}
