### [3159. Find Occurrences of an Element in an Array](https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/)
```java
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> idx = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==x) {
                idx.add(i);
            }
        }

        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            if(queries[i]>idx.size()) {
                ans[i] = -1;
            } else {
                ans[i] = idx.get(queries[i]-1);
            }
        }
        return ans;
    }
}
```
- **⏱ Time Complexity:** O(N+K) 
- **💾 Space:** O(K) 