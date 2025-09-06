### [Faulty Keyboard](https://leetcode.com/problems/faulty-keyboard/)

**Brute**
```java
class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') sb.reverse();  // O(current length) each time
            else sb.append(c);
        }
        return sb.toString();
    }
}
```
- **⏱ Time Complexity:** O(N^2)
- **💾 Space:** O(n)

**Optimal**
```java
class Solution {
    public String finalString(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        boolean inverted = false;

        for(char c: s.toCharArray()) {
            if(c=='i') {
                inverted = !inverted;
            } else if(inverted) {
                dq.offerFirst(c);
            } else {
                dq.offerLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(inverted) {
            while(!dq.isEmpty()) {
                sb.append(dq.pollLast());
            }
        } else {
            while(!dq.isEmpty()) {
                sb.append(dq.pollFirst());
            }
        }
        return sb.toString();
    }
}
```
- **⏱ Time Complexity:** O(n)
- **💾 Space:** O(n)