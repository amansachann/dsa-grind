// Brute force - Prefix Sum
class NumArray {
    int[] prefix;
    int[] arr;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        arr = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            arr[i] = nums[i];
            prefix[i] = sum + nums[i];
            sum += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int sum = 0;
        if(index>0) sum = prefix[index-1];
        arr[index] = val;
        for(int i=index; i<arr.length; i++) {
            prefix[i] = sum + arr[i];
            sum += arr[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return prefix[right];
        return prefix[right] - prefix[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */