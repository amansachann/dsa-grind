
// Brute
class Twitter {
    private List<int[]> tweets;
    private Map<Integer, Set<Integer>> following;
    public Twitter() {
        this.tweets = new ArrayList<>();
        this.following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{tweetId, userId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> followed = following.getOrDefault(userId, new HashSet<>());
        for(int i=tweets.size()-1; i>=0 && feed.size()<10; i--) {
            int[] tweet = tweets.get(i);
            if(userId==tweet[1] || followed.contains(tweet[1])) {
                feed.add(tweet[0]);
            }
        }
        return feed; 
    }
    
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

// Bettter - Min Heap
class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<int[]>> tweets;

    public Twitter() {
        this.time = 0;
        this.following = new HashMap<>();
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        this.tweets.putIfAbsent(userId, new ArrayList<>());
        this.tweets.get(userId).add(new int[]{++this.time, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);

        if(this.tweets.containsKey(userId)) {
            List<int[]> ownTweets = this.tweets.get(userId);
            for(int[] t: ownTweets) {
                pq.offer(t);
                if(pq.size()>10) pq.poll();
            }
        }

        Set<Integer> followed = this.following.getOrDefault(userId, Collections.emptySet());
        for(int user: followed) {
            List<int[]> userTweets = this.tweets.getOrDefault(user, new ArrayList<>());
            for(int[] t: userTweets) {
                pq.offer(t);
                if(pq.size()>10) pq.poll();
            }
        }

        while(!pq.isEmpty()) {
            feed.addFirst(pq.poll()[1]);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        this.following.putIfAbsent(followerId, new HashSet<>());
        this.following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(this.following.containsKey(followerId)) {
            this.following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

// Optimal - Max Heapclass Twitter {
    private int time;
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<int[]>> tweets;

    public Twitter() {
        this.time = 0;
        this.following = new HashMap<>();
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        this.tweets.putIfAbsent(userId, new ArrayList<>());
        this.tweets.get(userId).add(new int[]{++this.time, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        users.addAll(this.following.getOrDefault(userId, Collections.emptySet()));

        for(int u: users) {
            List<int[]> posts = this.tweets.getOrDefault(u, Collections.emptyList());
            int n = posts.size();
            if(n>0) {
                int[] lastPost = posts.get(n-1);
                pq.offer(new int[]{lastPost[0], lastPost[1], u, n-1});
            }
        }

        while(!pq.isEmpty() && feed.size()<10) {
            int[] top = pq.poll();
            feed.add(top[1]);
            int idx = top[3]-1;
            if(idx>=0) {
                int[] newPost = this.tweets.get(top[2]).get(idx);
                pq.offer(new int[]{newPost[0], newPost[1], top[2], idx});
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        this.following.putIfAbsent(followerId, new HashSet<>());
        this.following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(this.following.containsKey(followerId)) {
            this.following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */