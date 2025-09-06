### [Delete Mid of a Stack](https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1)

**Iterative Solution**
```java

class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        if (s.isEmpty()) return;

        int n = s.size();
        int mid = n / 2; // 0-based index of middle element

        Stack<Integer> aux = new Stack<>();

        // Remove elements above the middle
        for (int i = 0; i < mid; i++) {
            aux.push(s.pop());
        }

        // Pop the middle element
        s.pop();

        // Restore elements back to original stack
        while (!aux.isEmpty()) {
            s.push(aux.pop());
        }
    }
}
```
- **⏱ Time Complexity:** O(N)
- **💾 Space:** O(N) (for auxiliary stack)

**Recursive Solution**
```java
class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        // code here
        int n = s.size();
        int mid = n/2;
        deleteHelper(s, mid);
    }
    
    public void deleteHelper(Stack<Integer> s, int k) {
        if(k==0) {
            s.pop();
            return;
        }
        
        int top = s.pop();
        deleteHelper(s, k-1);
        s.push(top);
    }
}
```
- **⏱ Time Complexity:** O(N) (pop & push each element once)
- **💾 Space:** O(N) (recursion stack)