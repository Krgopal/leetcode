import java.util.HashMap;

class WordDictionary {
    String word;
    HashMap<Character, WordDictionary> children;
    public WordDictionary() {
        this.word = null;
        this.children = new HashMap<>();
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (Character letter : word.toCharArray()) {
            if (current.children.containsKey(letter)) {
                current = current.children.get(letter);
            } else {
                WordDictionary next = new WordDictionary();
                current.children.put(letter, next);
                current = next;
            }
        }
        current.word = word;
    }

    public boolean search(String word) {
        return searchRec(this, word, 0);
    }

    public boolean searchRec(WordDictionary parent, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        Character letter = word.charAt(index);
        if (letter == '.' && parent.children.isEmpty()) {
            return false;
        }
        if (letter != '.') {
            if (!parent.children.containsKey(letter)) {
                return false;
            }
            parent = parent.children.get(letter);
            return searchRec(parent, word, index + 1);
        } else {
            boolean found = false;
            for (WordDictionary child : parent.children.values()) {
                if (searchRec(child, word, index+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True

    }
}