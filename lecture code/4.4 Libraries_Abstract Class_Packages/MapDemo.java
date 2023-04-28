import java.util.*;

/**
 * 1. count the number of unique word
 * 2. Keep track of the number of times that specific word are mentioned.
 */
public class MapDemo {
    public static int countUniqueWord(List<String> words){
        Set<String> ss = new HashSet<>();
        for (String s: words){
            ss.add(s);
        }
        return ss.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> words, List<String> targets){
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String s: targets){
            wordCounts.put(s,0);
        }
        for (String s: words){
            if (wordCounts.containsKey(s)){
                int oldCount = wordCounts.get(s);
                wordCounts.put(s, oldCount+1);
            }
        }
        return wordCounts;
    }
}
