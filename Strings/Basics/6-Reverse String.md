### [Reverse String](https://leetcode.com/problems/reverse-string/description/)

**Two Pointers Approach**
```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
```
- **⏱ Time Complexity:** O(N)
- **💾 Space:** O(1)

**Recursive Solution**
```java
class Solution {
    public void reverse(char[] s, int left, int right) {
        if(left>=right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, ++left, --right);
    }

    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }
}
```
- **⏱ Time Complexity:** O(N)
- **💾 Space:** O(N)