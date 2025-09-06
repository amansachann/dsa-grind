### [LC-509. Fibonacci Number](https://leetcode.com/problems/fibonacci-number/description/)

**Recursive Approach (Not to use)**
```java
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        return fib(n-1) + fib(n-2);
    }
}
```
**⏱ Time Complexity**
- Each call to fib(n) makes two recursive calls (fib(n-1) and fib(n-2)), except at the base case.
- This forms a binary recursion tree of height n.
- The number of nodes (function calls) in this tree is about 2^n.

👉 So, Time Complexity = O(2^n) (exponential).

**🗂 Space Complexity**
- The maximum depth of the recursion tree is n (from fib(n) down to fib(1) or fib(0)).
👉 Space Complexity = O(n) (recursion stack).

⚡ That’s why plain recursion becomes super slow even for n = 40+.
👉 With memoization (top-down DP), you can reduce it to O(n) time and O(n) space.


**Iterative DP (simple & fast enough)**
```java
class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
```
- **⏱ Time Complexity:** O(N)
- **💾 Space:** O(1)