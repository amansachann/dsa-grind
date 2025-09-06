### [Group Anagrams](https://leetcode.com/problems/group-anagrams/description/)

**Brute**
```java
class Solution {
    public boolean isAnagram(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        boolean[] visited = new boolean[strs.length];

        for(int i=0; i<strs.length; i++) {
            if(visited[i]) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for(int j=i+1; j<strs.length; j++) {
                if(!visited[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(group);
        }
        return result;
    }
}
```
- **⏱ Time Complexity:** O(N^2 * K log K)
- **💾 Space:** O(N*K)

**Better**
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k->new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
```
- **⏱ Time Complexity:** O(N * K log K)
- **💾 Space:** O(N*K)