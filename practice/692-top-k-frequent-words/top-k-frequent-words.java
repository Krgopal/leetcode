class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            int count = frequency.getOrDefault(word, 0);
            frequency.put(word, count +1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> frequency.get(a) == frequency.get(b) ? b.compareTo(a) : frequency.get(a) - frequency.get(b));
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            queue.add(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(0, queue.poll());
        }
        return result;
    }
}