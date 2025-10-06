// Hashing / Counting Sort
class Solution {
    public void sortColors(int[] nums) {
        int[] vals = new int[3];
        for(int n: nums) {
            vals[n]++;
        }
        int j=0;
        for(int i=0; i<3; i++) {
            while(vals[i] != 0) {
                nums[j++] = i;
                vals[i]--;
            }
        }
    }
}