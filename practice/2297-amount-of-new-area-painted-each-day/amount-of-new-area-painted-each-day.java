class Solution {
    public int[] amountPainted(int[][] paint) {
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
}