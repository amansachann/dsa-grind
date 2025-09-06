### [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)

**Recursive Solution (Gives TLE)**
```java
class Solution {
    public int climbStairs(int n) {
        if(n<=3) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
```
- **⏱ Time Complexity:** O(2^N)
- **💾 Space:** O(1)

**Iterative DP**
```java
class Solution {
    public int climbStairs(int n) {
        if(n<=3) return n;
        int a = 2;
        int b = 3;
        for(int i=4; i<=n; i++) {
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
}
```
- **⏱ Time Complexity:** O(N)
- **💾 Space:** O(1)
