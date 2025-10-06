// Brute - Sorting 
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}

// Better - Min-Heap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        for(int n: map.keySet()) {
            pq.offer(new int[]{n, map.get(n)});
            if(pq.size()>k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty()) {
            result[i++] = pq.poll()[0];
        }
        return result;
    }
}

// Optimal - Bucket Sort
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for(int i=0; i<buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] result = new int[k];
        int j = 0;
        for(int i=nums.length; i>=0 && j<k; i--) {
            for(int p=0; p<buckets[i].size() && j<k; p++) {
                result[j++] = buckets[i].get(p);
            }
        }
        return result;
    }
}