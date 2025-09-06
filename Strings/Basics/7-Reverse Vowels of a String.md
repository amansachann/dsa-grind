### [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)

```java
class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while(left<right) {
            while(left<right && !vowels.contains(str[left])) {
                left++;
            }
            while(left<right && !vowels.contains(str[right])) {
                right--;
            }
            if(left<right) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
        return new String(str);
    }
}
```
- **⏱ Time Complexity:** O(N)
- **💾 Space:** O(1)