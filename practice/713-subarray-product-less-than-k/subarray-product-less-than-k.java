class Solution {
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int count =0;
        for (int i=0; i<nums.length; i++) {
            // System.out.println(nums[i]);
            if (nums[i] < k) {
                count++;
            } else {
                continue;
            }
            long product = nums[i];
            for (int j= i+1; j<nums.length; j++) {
                product *= nums[j];
                if (product< k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        long product = 1;
        int count = 0;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}