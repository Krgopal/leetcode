import java.util.Arrays;

public class CombinationSum4 {

    public static int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length][target +1];
        for (int i=0; i<nums.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
            dp[i][0] = 0;
        }
        for (int i=0; i< nums.length; i++) {
            for (int t = 1; t<=target; t++) {
                if (i > 0) {
                    dp[i][t] = dp[i-1][t];
                }
                if (t >= nums[i]) {
                    dp[i][t] = Math.min(dp[i][t], dp[i][t-nums[i]] + 1);
                }
            }
        }
        return dp[nums.length -1][target] == Integer.MAX_VALUE -1 ? -1 : dp[nums.length -1][target];
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        System.out.println(combinationSum4(input, 4));
    }
}
