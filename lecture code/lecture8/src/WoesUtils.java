public  class WoesUtils {
    public static String longest(List61B<String> list) {
        int maxDex = 0;
        for (int i=0;i< list.size();i+=1){
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if(thisString.length()> longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }
//    public static String longest(AList<String> list) {
//        int maxDex = 0;
//        for (int i=0;i< list.size();i+=1){
//            String longestString = list.get(maxDex);
//            String thisString = list.get(i);
//            if(thisString.length()> longestString.length()){
//                maxDex = i;
//            }
//        }
//        return list.get(maxDex);
//    }
    public static void main(String[] args) {
        List61B<String> someList = new SLList<String>();
        someList.addLast("egg");
        someList.addLast("boyz");
        someList.addLast("watching");
        System.out.println(longest(someList));
    }
}