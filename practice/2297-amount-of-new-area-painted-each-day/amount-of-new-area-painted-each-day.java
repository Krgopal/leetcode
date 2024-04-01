class Solution {
    public int[] amountPainted1(int[][] paint) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[paint.length];
        int index = 0;
        for (int[] p : paint) {
            int diff = 0;
            int lo = p[0], start = p[0];
            int hi = p[1], end = p[1];
            if (map.floorKey(lo) != null) {
                int key = map.floorKey(lo);
                if (map.get(key) >= lo) {
                    start = key;
                }
            }
            if (map.floorKey(hi) != null) {
                int key = map.floorKey(hi);
                end = Math.max(map.get(key), end);
            }
            for (int key : map.subMap(start, true, end, true).keySet()) {
                int val = map.get(key);
                diff += (Math.min(val , p[1]) - Math.max(key , p[0]));
            }
            diff = (hi - lo) - diff;
            map.subMap(start, true, end, true).clear();
            map.put(start, end);
            result[index++] = diff;
        }
        return result;
    }

    public int[] amountPainted(int[][] paint) {
        int n = paint.length;
        int[] ans = new int[n];
        int max = paint[0][1];
        for (int[] p : paint) {
            max = Math.max(max, p[1]);
        }
        int i=0;
        int[] line = new int[max + 1];
        for (int[] p : paint) {
            int start = p[0];
            int end = p[1];
            int amount = 0;
            while (start < end) {
                int nextJump = Math.max(start + 1, line[start]);
                amount += line[start] == 0 ? 1 : 0;
                line[start] = Math.max(line[start], end);
                start = nextJump;
            }
            ans[i++] = amount;
        }
        return ans;
    }
}