class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs[0].length(); i++) {
            for(String s: strs) {
                if(i == s.length() || s.charAt(i)!=strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}

// Another approach
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int i=0;
        while(i<s1.length()) {
            if(s1.charAt(i)==s2.charAt(i)) i++;
            else break;
        }
        return s1.substring(0, i);
    }
}