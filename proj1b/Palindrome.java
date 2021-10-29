public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> da = new LinkedListDeque<>();
        char c;
        for (int i = 0; i < word.length(); i = i + 1) {
            c = word.charAt(i);
            da.addLast(c);
        }
        return da;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> a = wordToDeque(word);
        if (a.size() == 0 && a.size() == 1) {
            return true;
        }
        int num = a.size() / 2;
        for (int i = 0; i < num; i = i + 1) {
            if (a.removeFirst() != a.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> a = wordToDeque(word);
        if (a.size() == 0 && a.size() == 1) {
            return true;
        }
        int num = a.size() / 2;
        for (int i = 0; i < num; i = i + 1) {
            if(!cc.equalChars(a.removeFirst(), a.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
