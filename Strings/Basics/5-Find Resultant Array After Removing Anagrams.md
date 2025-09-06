### [Find Resultant Array After Removing Anagrams](https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/)

```java
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevKey = ""; 

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            if (!key.equals(prevKey)) {
                result.add(word);
                prevKey = key;
            }
        }
        return result;
    }
}
```