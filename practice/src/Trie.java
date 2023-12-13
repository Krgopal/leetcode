import java.util.ArrayList;
import java.util.List;

class Trie {

    char value;
    boolean completeWord;
    Trie[] child;
    public Trie() {
        this.child = new Trie[26];
    }

    public void insert(String word) {
        Trie child = this;
        for (int i=0; i<word.length(); i++) {
            if (child.child[(word.charAt(i) - 'a')] == null) {
                Trie childNode = new Trie();
                childNode.value = word.charAt(i);
                child.child[(word.charAt(i) - 'a')] = childNode;
                child = childNode;
            } else {
                child = child.child[(word.charAt(i) - 'a')];
            }
            if (i== word.length() -1) {
                child.completeWord = true;
            }
        }
    }

    public boolean search(String word) {
        Trie root = this;
        for (int i=0; i<word.length(); i++) {
            if (root.child[word.charAt(i) - 'a'] == null) {
                return false;
            } else {
                root = root.child[word.charAt(i)- 'a'];
            }
        }
        return root.completeWord;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i=0; i<prefix.length(); i++) {
            if (root.child[(prefix.charAt(i) - 'a')] == null) {
                return false;
            } else {
                root = root.child[(prefix.charAt(i) - 'a')];
            }
        }
        return root != null;
    }
}
