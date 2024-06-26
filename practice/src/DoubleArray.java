import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.



Example 1:

Input: changed = [1,3,4,2,6,8]
Output: [1,3,4]
Explanation: One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].
Example 2:

Input: changed = [6,3,0,1]
Output: []
Explanation: changed is not a doubled array.
Example 3:

Input: changed = [1]
Output: []
Explanation: changed is not a doubled array.


Constraints:

1 <= changed.length <= 105
0 <= changed[i] <= 105

 */

public class DoubleArray {
    public int[] findOriginalArray1(int[] changed) {
        // It can't be doubled array, if the size is odd
        if (changed.length % 2 == 1) {
            return new int[0];
        }

        // Sort in ascending order
        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap<>();
        // Store the frequency in the map
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] original = new int[changed.length / 2];
        int index = 0;
        for (int num : changed) {
            // If element exists
            if (freq.get(num) > 0) {
                freq.put(num, freq.get(num) - 1);
                int twiceNum = num * 2;
                if (freq.containsKey(twiceNum) && freq.get(twiceNum) > 0) {
                    // Pair up the elements, decrement the count
                    freq.put(twiceNum, freq.get(twiceNum) - 1);
                    // Add the original number to answer
                    original[index++] = num;
                } else {
                    return new int[0];
                }
            }
        }

        return original;
    }

    public static void main(String[] args) {
        DoubleArray bs = new DoubleArray();
        int[] asdf = new int[]{2, 1, 2, 4, 2, 4};
        System.out.println(Arrays.toString(bs.findOriginalArray1(asdf)));
    }

}
