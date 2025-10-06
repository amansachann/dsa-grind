### [Wave Array](https://www.geeksforgeeks.org/problems/wave-array-1587115621/1?track=amazon-arrays&batchId=192)


_If array is sorted:_
```java
class Solution {
    public void sortInWave(int arr[]) {
        // code here
        for(int i=0; i<arr.length; i+=2) {
            if(i+1<arr.length) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
}
```
_If array is not sorted:_
```java
class Solution {
    public void sortInWave(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // For even index, arr[i] should be greater or equal
            if (i % 2 == 0) {
                if (i > 0 && arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
                if (i < n - 1 && arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } 
            // For odd index, arr[i] should be smaller or equal
            else {
                if (i > 0 && arr[i] > arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
                if (i < n - 1 && arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```