### [Equilibrium Point](https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1)

```java
class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        
        int totalSum = Arrays.stream(arr).sum();
        
        int leftSum = 0;
        
        for(int i=0; i<n; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
```
