### [Subset Sums](https://www.geeksforgeeks.org/problems/subset-sums2234/1&selectedLang=python3)

```java
// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        getSubsets(arr, 0, 0, result);
        return result;
    }
    
    public void getSubsets(int[] arr, int i, int currSum, ArrayList<Integer> result) {
        if(i==arr.length) {
            result.add(currSum);
            return;
        }
        getSubsets(arr, i+1, currSum+arr[i], result);
        getSubsets(arr, i+1, currSum, result);
    }
}
```
- **⏱ Time Complexity:** O(2^N)
- **💾 Space:**  O(N + 2^N) 