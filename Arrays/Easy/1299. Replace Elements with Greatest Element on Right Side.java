class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int rightMax = -1;
        for(int i=n-1; i>=0; i--) {
            int el = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(rightMax, el);
        }
        return arr;
    }
}