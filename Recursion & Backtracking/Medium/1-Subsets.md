### [78. Subsets](https://leetcode.com/problems/subsets/)

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
        getAllSubsets(nums, ans, i+1, res);
    }
}
```
- **⏱ Time Complexity:** O(2^N * N) 
- **💾 Space:** O(N) O(4^n × n) (result storage) + O(n) (stack)