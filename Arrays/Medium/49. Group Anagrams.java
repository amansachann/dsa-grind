// Brute
class Solution {
    private boolean checkAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int f: freq) {
            if(f != 0) return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                visited[i] = true;
                for(int j=i+1; j<n; j++) {
                    if(!visited[j] && checkAnagram(strs[i], strs[j])) {
                        temp.add(strs[j]);
                        visited[j] = true;
                    }
                }
                result.add(temp);
            }
        }

        return result;
    }
}

// Better 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String s: strs) {
            char[] cas = s.toCharArray();
            Arrays.sort(cas);
            String key = new String(cas);

            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}

// Optimal
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String s: strs) {
            int[] hash = new int[26];
            for(char ch: s.toCharArray()) {
                hash[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : hash) {
                sb.append('#').append(count);
            }
            String key = sb.toString();

            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}