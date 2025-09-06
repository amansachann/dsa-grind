### [39. Combination Sum](https://leetcode.com/problems/combination-sum/description/)

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void getCombinations(int[] arr, int target, int i, List<Integer> temp, List<List<Integer>> ans) {
        if(target<0 || i==arr.length) return;
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(arr[i]<=target) {
            temp.add(arr[i]);
            getCombinations(arr, target-arr[i], i, temp, ans);
            temp.remove(temp.size()-1);
        }
        getCombinations(arr, target, i+1, temp, ans);
    }
}
```
- **⏱ Time Complexity:** O(2^N)
- **💾 Space:**  O(S*k) (S solutions each of length k)

