class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while(l<r) {
            while(l<s.length() && !Character.isLetterOrDigit(str.charAt(l))) l++;
            while(r>=0 && !Character.isLetterOrDigit(str.charAt(r))) r--;
            if(l<r && str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}