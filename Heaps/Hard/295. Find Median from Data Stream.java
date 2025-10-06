// Brute Force - Gives TLE
class MedianFinder {
    List<Integer> values;

    public MedianFinder() {
        this.values = new ArrayList<>();
    }
    
    public void addNum(int num) {
        this.values.add(num);
    }
    
    public double findMedian() {
        Collections.sort(values);
        int n = values.size();
        if(n%2!=0) {
            int mid = n/2;
            return (double) values.get(mid);
        } else {
            int mid2 = n/2;
            int mid1 = mid2-1;
            return (double)(values.get(mid1)+values.get(mid2))/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Better - Binary Search to find insertion point
class MedianFinder {
    List<Integer> values;

    public MedianFinder() {
        this.values = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int idx = Collections.binarySearch(values, num);
        if (idx < 0) idx = -(idx + 1); 
        values.add(idx, num);
    }
    
    public double findMedian() {
        int n = values.size();
        if(n%2!=0) {
            int mid = n/2;
            return (double) values.get(mid);
        } else {
            int mid2 = n/2;
            int mid1 = mid2-1;
            return (double)(values.get(mid1)+values.get(mid2))/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Optimal - Two Heaps
class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        
        if(!large.isEmpty() && small.peek()>large.peek()) {
            large.offer(small.poll());
        }

        if(small.size() > large.size()+1) {
            large.offer(small.poll());
        } else if(small.size()<large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size()>large.size()) {
            return small.peek();
        }
        return (double) (small.peek() + large.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */