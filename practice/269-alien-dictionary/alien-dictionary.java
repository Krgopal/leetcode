class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> charMap = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0));
                charMap.put(c, charMap.getOrDefault(c,new ArrayList<>()));
            }
        }
        for (int s =0; s< words.length -1; s++) {
            String word1 = words[s];
            String word2 = words[s +1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int i=0; i<Math.min(word1.length(), word2.length()); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    charMap.get(word1.charAt(i)).add(word2.charAt(i));
                    count.put(word2.charAt(i), count.get(word2.charAt(i)) + 1);
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue().equals(0)) {
                queue.add(entry.getKey());
            }
        }
        while(!queue.isEmpty()) {
            Character ch = queue.remove();
            sb.append(ch);
            for(Character next : charMap.get(ch)) {
                count.put(next, count.get(next) -1);
                if (count.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        if (sb.length() < count.size()) {
            return "";
        }
        return sb.toString();
    }
}