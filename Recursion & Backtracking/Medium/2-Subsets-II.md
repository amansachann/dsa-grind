### [90. Subsets II](https://leetcode.com/problems/subsets-ii/)

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        getAllSubsets(nums, new ArrayList<>(), 0, res);
        return res;
    }

    public void getAllSubsets(int[] nums, List<Integer> ans, int i, List<List<Integer>> res) {
        if(i==nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        // Include
        ans.add(nums[i]);
        getAllSubsets(nums, ans, i+1, res);

        // Backtrack
        ans.remove(ans.size()-1);

        // Exclude
        int idx = i+1;
        while(idx<nums.length && nums[idx]==nums[i]) {
            idx++;
        }
        getAllSubsets(nums, ans, idx, res);
    }
}
```
- **⏱ Time Complexity:** O(2^N * N) 
- **💾 Space:** O(N) 