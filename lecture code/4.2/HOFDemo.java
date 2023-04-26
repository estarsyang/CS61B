public class HOFDemo {
    /** demonstrates higher order function in Java. */
    public static int do_twice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] argus){
        IntUnaryFunction tenX = new TenX();
        System.out.println(do_twice(tenX,2));
    }
}
