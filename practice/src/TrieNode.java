import java.util.HashMap;


class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode() {}
}
