class Solution {
    public int longestValidParenthesesdp(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i>= 2 ? dp[i-2] : 0) + 2;
                } else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] -1) == '(') {
                    dp[i] = dp[i -1] + (i - dp[i-1] >=2 ? dp[i -dp[i-1] -2] : 0) + 2;
                }
                maxLength =  Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }

    public int longestValidParentheses(String s) {
        int maxAns = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                maxAns = Math.max(maxAns, i - stack.peek());
            }
        }
        return maxAns;
    }
}