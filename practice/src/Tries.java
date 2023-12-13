import java.util.HashMap;

class Tries {
    String word = null;
    HashMap<Character, Tries> children = new HashMap<>();
    public Tries() {}
}
