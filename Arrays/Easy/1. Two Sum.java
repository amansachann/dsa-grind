class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            int comp = target - nums[i];
            if(hash.containsKey(comp)) {
                ans[0] = hash.get(comp);
                ans[1] = i;
                return ans;
            } 
            hash.put(nums[i], i);
        }
        return ans;
    }
}