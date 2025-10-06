class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        for(int j=0; j<s.length(); j++) {
            if(s.charAt(j)==t.charAt(i)) {
                i++;
            }
            if(i==t.length()) return 0;
        }
        return t.length()-i;
    }
}