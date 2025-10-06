class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        int i = s.length()-1;
        while(s.charAt(i)==' ') i--;
        while(i>=0) {
            if(s.charAt(i)==' ') break;
            ans++;
            i--;
        }
        return ans;
    }
}