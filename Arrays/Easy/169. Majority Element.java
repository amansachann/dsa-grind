// Hashmap approach
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int maxCount = 0;
        int res = 0;
        for(int n: nums) {
            mp.put(n, mp.getOrDefault(n, 0)+1);
            if(mp.get(n)>maxCount) {
                maxCount = mp.get(n);
                res = n;
            }
        } 
        return res;
    }
}

// Moore's Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int n: nums) {
            if(n==res) {
                count++; 
            } else {
                count--;
            }
            if(count < 0) {
                res = n;
                count = 1;
            }
        }
        return res;
    }
}