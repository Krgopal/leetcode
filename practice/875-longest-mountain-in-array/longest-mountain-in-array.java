class Solution {
    public static int longestMountain(int[] arr) {
        int maxLength = 0;
        int left = 0;
        int right = 1;
        boolean increasing = true;
        boolean increase = false;
        boolean decrease = false;
        while (right < arr.length) {
            if (arr[right -1] == arr[right]) {
                if (increase && decrease) {
                    int length = right - left;
                    maxLength = Math.max(maxLength, length);
                }
                left = right;
                right++;
                increase = false;
                decrease = false;
                increasing = true;
            } else if (increasing && arr[right -1] < arr[right]) {
                increase = true;
                right++;
            } else if (increasing && arr[right - 1] > arr[right]) {
                increasing = false;
            } else if (!increasing && arr[right - 1] > arr[right]) {
                decrease = true;
                right++;
            } else {
                if (increase && decrease) {
                    int length = right - left ;
                    maxLength = Math.max(maxLength, length);
                }
                left = right-1;
//                right++;
                increase = false;
                decrease = false;
                increasing = true;
            }
        }
        if (increase && decrease) {
            int length = right - left;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}