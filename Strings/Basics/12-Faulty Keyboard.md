### [Faulty Keyboard](https://leetcode.com/problems/keyboard-row/)

**Brute**
```java
class Solution {
    public boolean checkRow(char[] arr, String row) {
        int i=1;
        while(i<arr.length) {
            if(row.indexOf(arr[i])==-1) {
                return false;
            }
            i++;
        }
        return true;
    }
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> ans = new ArrayList<>();
        for(String word: words) {
            String lower = word.toLowerCase();
            if(row1.indexOf(lower.charAt(0)) != -1 && checkRow(lower.toCharArray(), row1)) {
                ans.add(word);
            } else if(row2.indexOf(lower.charAt(0)) !=-1 && checkRow(lower.toCharArray(), row2)) {
                ans.add(word);
            } else if(row3.indexOf(lower.charAt(0)) != -1 && checkRow(lower.toCharArray(), row3)) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }
}
```
- **⏱ Time Complexity:** O(10*n)     _(Closer to n^2 in worst case)_
- **💾 Space:** O(1)

**Optimal**
```java
class Solution {

    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> ans = new ArrayList<>();

        int[] rows = new int[26];
        for(char c: row1.toCharArray()) rows[c-'a'] = 1;
        for(char c: row2.toCharArray()) rows[c-'a'] = 2;
        for(char c: row3.toCharArray()) rows[c-'a'] = 3;

        for(String word: words) {
            String lower = word.toLowerCase();
            int row = rows[lower.charAt(0)-'a'];
            boolean valid = true;
            for(char ch: lower.toCharArray()) {
                if(rows[ch-'a']!=row) {
                    valid = false;
                    break;
                }
            }
            if(valid) ans.add(word);
        }
        return ans.toArray(new String[0]);
    }
}
```
- **⏱ Time Complexity:** O(n)    
- **💾 Space:** O(1)