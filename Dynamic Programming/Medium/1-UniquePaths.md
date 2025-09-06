### [62. Unique Paths](https://leetcode.com/problems/unique-paths/description/)
```java
class Solution {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        return solve(m, n);
    }

    private int solve(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (dp[m][n] != 0) return dp[m][n];
        
        int a = m > 1 ? solve(m-1, n) : 0;
        int b = n > 1 ? solve(m, n-1) : 0;
        
        return dp[m][n] = a + b;
    }
}
```