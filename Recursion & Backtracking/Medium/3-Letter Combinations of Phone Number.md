### [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)
**Recursive Solution**
```java
class Solution {
    static String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = getCombinations(digits);
        if(ans.size()==1 && ans.get(0).isEmpty()) {
            return new ArrayList<>();
        }
        return ans;
    }

    public List<String> getCombinations(String digits) {
        if(digits.isEmpty()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        char ch = digits.charAt(0);
        String remaining = digits.substring(1);
        List<String> remCombs = getCombinations(remaining);
        List<String> currCombs = new ArrayList<>();
        String key = codes[ch-'0'];
        for(String str: remCombs) {
            for(char c: key.toCharArray()) {
                currCombs.add(c+str);
            }
        }
        return currCombs;
    }   
}
```
- **⏱ Time Complexity:** O(4^N * N) 
- **💾 Space:**  O(4^n × n) (result storage) + O(n) (stack)

**BFS Solution**
```java
class Solution {
    static String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        Queue<String> q = new LinkedList<>();
        q.add("");


        for(char digit: digits.toCharArray()) {
            String letters = codes[digit-'0']; 
            int size = q.size();

            for(int i=0; i<size; i++) {
                String prefix = q.poll();
                for(char ch: letters.toCharArray()) {
                    q.add(prefix+ch);
                }
            }
        }

        return new ArrayList(q);
    }   
}
```
- **⏱ Time Complexity:** O(4^N * N) (same reason: must enumerate all combinations)
- **💾 Space:**  O(4^n × n) (same as recursion, but no recursion stack)
