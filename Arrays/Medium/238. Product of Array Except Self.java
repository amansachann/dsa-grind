// Brute - TLE (O(N^2)) 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            int left = 1;
            for(int j=i-1; j>=0; j--) {
                left *= nums[j];
            }

            int right = 1;
            for(int j=i+1; j<n; j++) {
                right *= nums[j];
            }

            result[i] = left*right;
        }

        return result;

    }
}


// Better - O(N)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        for(int i=1; i<n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i=0; i<n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}



// Optimal - O(N)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int prod = 1;
        for(int i=0; i<n; i++) {
            result[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for(int i=n-1; i>=0; i--) {
            result[i] *= prod;
            prod *= nums[i];
        }
        return result;

    }
}