class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        UnionFind dsu = new UnionFind();
        for (List<String> pair : similarPairs) {
            dsu.addWord(pair.get(0));
            dsu.addWord(pair.get(1));
            dsu.union(pair.get(0), pair.get(1));
        }
        for (int i=0; i<sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (dsu.isWordPresent(sentence1[i]) && dsu.isWordPresent(sentence2[i]) && dsu.find(sentence1[i]) == dsu.find(sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
}

class UnionFind {
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> rank = new HashMap<>();

    public void addWord(String word) {
        if (!parent.containsKey(word)) {
            parent.put(word, word);
            rank.put(word, 0);
        }
    }

    public boolean isWordPresent(String word) {
        return parent.containsKey(word);
    }

    public String find(String word) {
        if (parent.get(word) != word) {
            parent.put(word, find(parent.get(word)));
        }
        return parent.get(word);
    }

    public void union(String word1, String word2) {
        String word1set = find(word1);
        String word2set = find(word2);
        if (word1set == word2set) {
            return;
        } else if (rank.get(word1set) < rank.get(word2set)) {
            parent.put(word1set, word2set);
        } else if (rank.get(word1set) > rank.get(word2set)) {
            parent.put(word2set, word1set);
        } else {
            parent.put(word2set, word1set);
            rank.put(word1set, rank.get(word1set) + 1);
        }
    }
}