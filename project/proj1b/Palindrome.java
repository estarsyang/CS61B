public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new LinkedListDeque();
        for(int i=0;i<word.length();i++){
            char s = word.charAt(i);
            d.addLast(s);
        }
        return d;
    };

    public boolean isPalindrome(String word){
        int len = word.length();
        if(len == 1 || len == 0){
            return true;
        }
        /*
        // method1
        String str = "";
        boolean res = false;
        for (int i=word.length() - 1;i>=0;i--){
            str = str + word.charAt(i);
        }
        if(word.equals(str)){
            res = true;
        }
        return res;
         */
        /*
        // method2
        int i =0, j=word.length() - 1;
        while (i<j){
            if (word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
         */
        Deque<Character> wDeque = wordToDeque(word);

        return isPalindromeHelp(wDeque);
    }
    public boolean isPalindromeHelp(Deque<Character> wDeque){
        int dSize = wDeque.size();
        if (dSize == 1 || dSize == 0){
            return true;
        }
        Character first = wDeque.removeFirst();
        Character last = wDeque.removeLast();
        return (first == last) && isPalindromeHelp(wDeque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wDeque = wordToDeque(word);

        return isPalindromeHelp(wDeque,cc);
    }
    public boolean isPalindromeHelp(Deque<Character> wDeque, CharacterComparator cc){
        int dSize = wDeque.size();
        if (dSize == 1 || dSize == 0){
            return true;
        }
        Character first = wDeque.removeFirst();
        Character last = wDeque.removeLast();
        return (cc.equalChars(first,last)) && isPalindromeHelp(wDeque,cc);
    }
}
