class Solution {
    // public int convertArray(int[] nums) {
        
    // }

    int helper(int[] nums, int[] levels) {
        var dp = new HashMap<Integer,Integer>();
        for(var num : nums) {
            var cur_res = Integer.MAX_VALUE;
            for(var level : levels) {
                var prev_res = dp.getOrDefault(level,0);
                cur_res = Math.min(cur_res, prev_res+Math.abs(num-level));
                dp.put(level,cur_res);
            }
        }
        return dp.get(levels[levels.length-1]);
    }
    public int convertArray(int[] nums) {
        var levels = Arrays.stream(nums).distinct().sorted().toArray();
        var nums2 = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            nums2[nums.length-1-i]=nums[i];
        }
        return Math.min(helper(nums, levels),helper(nums2, levels));
    }
}