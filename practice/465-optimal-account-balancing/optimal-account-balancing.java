class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tran : transactions) {
            map.put(tran[0], map.getOrDefault(tran[0], 0) - tran[2]);
            map.put(tran[1], map.getOrDefault(tran[1], 0) + tran[2]);
        }
        int n = map.size();
        int i=0;
        int[] balance = new int[n];
        for (int k : map.keySet()) {
            balance[i++] = map.get(k);
        }
        return dfs(0, balance);
    }

    private int dfs(int idx, int[] balance) {
        if (idx == balance.length) return 0;
        if (balance[idx] == 0) {
            return dfs(idx +1, balance);
        }
        int res = Integer.MAX_VALUE;
        int currDebt = balance[idx];
        for (int i=idx +1; i<balance.length; i++) {
            if (balance[i] * currDebt >= 0) {
                continue;
            }
            balance[i] += currDebt;
            res = Math.min(res, 1 + dfs(idx + 1, balance));
            balance[i] -= currDebt;
        }
        return res;
    }
}