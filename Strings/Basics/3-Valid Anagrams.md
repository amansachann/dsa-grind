### [Valid Anagram](https://leetcode.com/problems/valid-anagram/description/)

**Brute**
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray();
        Arrays.sort(sortedS);
        Arrays.sort(sortedT); 
        
        return Arrays.equals(sortedS, sortedT);
    }
}
```

**Optimal**
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count = new int[26];

        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int c: count) {
            if(c!=0) return false;
        }
        return true;
    }
}
```