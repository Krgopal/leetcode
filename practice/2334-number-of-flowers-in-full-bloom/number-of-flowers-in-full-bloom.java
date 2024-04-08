class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];
        for (int i=0; i<flowers.length; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1] + 1;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] result = new int[people.length];
        for (int i=0; i<people.length; i++) {
            int person = people[i];
            int startIndex = binarySearch(start, person);
            int endIndex = binarySearch(end, person);
            result[i] = startIndex - endIndex;
        }
        return result;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (right + left)/2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
}