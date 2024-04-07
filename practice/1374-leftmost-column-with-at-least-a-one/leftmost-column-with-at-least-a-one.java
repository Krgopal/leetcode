/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int column = dimension.get(1);
        int smallestIndex = column;
        for (int j=0; j<rows; j++) {
            int left = 0;
            int right = column -1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (binaryMatrix.get(j, mid) == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (binaryMatrix.get(j, left) == 1) {
                smallestIndex = Math.min(smallestIndex, left);
            }
        }
        return smallestIndex == column ? -1 : smallestIndex;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int response = -1;
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int col = dimension.get(1) -1;
        for (int i=0; i<rows; i++) {
            while (col >= 0) {
                if (binaryMatrix.get(i, col) == 1) {
                    response = col;
                    col--;
                } else {
                    break;
                } 
            }
        }
        return response;
    }
}