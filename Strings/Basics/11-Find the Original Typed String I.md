### [Find the Original Typed String I](https://leetcode.com/problems/find-the-original-typed-string-i/description/)

**Intution:**
- Start with 1 possible string: the string itself if no long key press occurred.
- Each consecutive duplicated character (i.e., where word[i] == word[i - 1]) represents an opportunity — Alice may have held that key too long just for that one instance.
- So, every such adjacent pair adds +1 to the count of possible originals.
- The final answer is simply:
1 (base case) + the number of adjacent equal character pairs.

```java
class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        for(int i=1; i<word.length(); i++) {
            if(word.charAt(i)==word.charAt(i-1)) {
                ans++;
            }
        }
        return ans;
    }
}
```
- **⏱ Time Complexity:** O(n)
- **💾 Space:** O(1)