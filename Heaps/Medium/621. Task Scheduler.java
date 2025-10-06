// Brute Force
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch: tasks) {
            freq[ch-'A']++;
        }

        int time = 0;
        int remaining = tasks.length;
        
        int[] nextAvailable = new int[26];
        while(remaining>0) {
            int bestTask = -1;
            for(int i=0; i<26; i++) {
                if(freq[i] > 0 && nextAvailable[i] <= time) {
                    if(bestTask == -1 || freq[i] > freq[bestTask]) {
                        bestTask = i;
                    }
                }
            }

            if(bestTask != -1) {
                freq[bestTask]--;
                remaining--;
                nextAvailable[bestTask] = time+n+1;
            }
            time++; 
        }
        return time;
    }
}

/*
Time: O(m × n) worst-case (but practically 26 × T)
Space: O(1)
*/

// Better Solution
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t: tasks) freq[t-'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
        for(int f: freq) {
            if(f != 0) maxHeap.offer(f);
        }

        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int curr = maxHeap.poll()-1;
                if(curr>0) {
                    cooldown.offer(new int[]{curr, time+n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1]==time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }
        return time;
    } 
}
/*
Time Complexity: O(m)
Space Complexity: O(1)
*/