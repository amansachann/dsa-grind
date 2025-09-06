### [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void getCombinations(int[] arr, int target, int start, List<Integer> temp, List<List<Integer>> ans) {
        if(target<0) return;
        if(target==0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(i>start && arr[i]==arr[i-1]) continue;

            if (arr[i] > target) break;  // pruning

            temp.add(arr[i]);
            getCombinations(arr, target-arr[i], i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
        
    }
}
```
- **⏱ Time Complexity:** O(2^N + S·k) (often written as O(2^N·k) for simplicity)
- **💾 Space Complexity:** O(N + S·k) (sometimes simplified to O(S·k) if ignoring recursion stack)