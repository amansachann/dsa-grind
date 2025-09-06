### [77. Combinations](https://leetcode.com/problems/combinations/description/)

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void getCombinations(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if(temp.size()==k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++) {
            temp.add(i);
            getCombinations(i+1, n, k, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
```
- **⏱ Time Complexity:** O( C(n, k) · k )
- **💾 Space:**  O(k)