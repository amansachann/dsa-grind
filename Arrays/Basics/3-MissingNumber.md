
### [Missing Number](https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1)
```java
class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length+1;
        long totalSum = 0;
        for(int x: arr) {
            totalSum += x;
        }
        long nSum = (long)n*(n+1)/2;
        long ans = nSum - totalSum;
        return (int) ans;
    }
}
```
_Using Bit Manipulation:_
```java
class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length+1;
        int xor = 0;
        
        for(int i=1; i<=n; i++) {
            xor ^= i;
        }
        
        for(int x: arr) {
            xor ^= x;
        }
        
        return xor;
    }
} 
```
_Java one liner:_
```java
class Solution {
    int missingNum(int[] arr) {
        int n = arr.length + 1;
        return (int)((long)n*(n+1)/2 - Arrays.stream(arr).asLongStream().sum());
    }
}
```
