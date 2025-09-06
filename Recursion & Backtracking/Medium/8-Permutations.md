### [46. Permutations](https://leetcode.com/problems/permutations/description/)

**Approach-1**
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        generatePermutations(nums, new ArrayList<>(), marked, result);
        return result;
    }

    public void generatePermutations(int[] nums, List<Integer> temp, boolean[] marked, List<List<Integer>> result) {
        if(temp.size()==nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int j=0; j<nums.length; j++) {
            if(!marked[j]) {
                temp.add(nums[j]);
                marked[j] = true;
                generatePermutations(nums, temp, marked, result);
                temp.remove(temp.size()-1);
                marked[j] = false;
            }
        }
    }
}
```
- **⏱ Time Complexity:** O(n×n!)
- **💾 Space:**  O(n×n!)

**Approach-2**
