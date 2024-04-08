class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1001];
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = dp[j][diff] > 0 ? 1 + dp[j][diff] : 2;
                result = Math.max(result, dp[i][diff]);
            }
        }
        return result;
    }
}