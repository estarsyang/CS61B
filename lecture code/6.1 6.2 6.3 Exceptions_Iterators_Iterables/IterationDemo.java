public class IterationDemo {


    public static void main(String[] args) {
        ArrayMap<String, Integer> am = new ArrayMap<>();
        am.put("hello", 5);
        am.put("syrups", 10);
        am.put("kingdom", 5);

        ArrayMap.KeyIterator ami = am.new KeyIterator();

        while(ami.hasNext()){
            System.out.println(ami.next());
        }

        for (String s: am){
            System.out.println(s);
        }
    }
}
