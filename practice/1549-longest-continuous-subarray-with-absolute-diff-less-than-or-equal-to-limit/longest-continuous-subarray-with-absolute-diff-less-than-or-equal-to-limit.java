class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> maxd= new ArrayDeque<>();
        ArrayDeque<Integer> mind = new ArrayDeque<>();
        int i=0, j;
        for (j=0; j<nums.length; j++) {
            while (!maxd.isEmpty() && nums[j] > maxd.peekLast()) {
                maxd.pollLast();
            }
            while (!mind.isEmpty() && nums[j] < mind.peekLast()) {
                mind.pollLast();
            }
            maxd.add(nums[j]);
            mind.add(nums[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[i]) {
                    maxd.poll();
                }
                if (mind.peek() == nums[i]) {
                    mind.poll();
                }
                i++;
            }
        }
        return j -i;
    }
}