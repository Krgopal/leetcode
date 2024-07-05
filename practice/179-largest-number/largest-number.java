class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> (String.valueOf(b) + String.valueOf(a)).compareTo(String.valueOf(a) + String.valueOf(b)));
        for (int val : nums) {
            queue.add(val);
        }
        String res ="";
        while(!queue.isEmpty()) {
            res += String.valueOf(queue.poll());
        }
        if (res.startsWith("0")) {
            return "0";
        }
        return res;
    }
}