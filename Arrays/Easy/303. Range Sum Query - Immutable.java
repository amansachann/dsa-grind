// Prefix Sum
class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            prefix[i] = sum + nums[i];
            sum += nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return prefix[right];
        return prefix[right] - prefix[left-1];
    }
}