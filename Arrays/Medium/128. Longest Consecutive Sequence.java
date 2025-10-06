class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int n: nums) numSet.add(n);
        int ans = 0;
        for(int n: numSet) {
            if(!numSet.contains(n-1)) {
                int l = 1;
                while(numSet.contains(n+l)) l++;
                ans = Math.max(l, ans);
            }
        }
        return ans;
    }
}