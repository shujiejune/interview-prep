class Twitter {
	int tweetInd;
	Map<Integer, Integer> tweetMap;  // (tweetId, tweetIndex)
	Map<Integer, List<Integer>> userMap;
	Map<Integer, Set<Integer>> followMap;

	public Twitter() {
		tweetInd = 0;
		tweetMap = new HashMap<>();
		userMap = new HashMap<>();
		followMap = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		tweetMap.put(tweetId, tweetInd);
		if (!userMap.containsKey(userId)) {
			userMap.put(userId, new LinkedList<>());
		}
		userMap.get(userId).add(tweetId);
		tweetInd++;
	}

	public List<Integer> getNewsFeed(int userId) {
		List<Integer> feed = new ArrayList<>();
		Set<Integer> users = followMap.get(userId);
		users.add(userId);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<>(){
			@Override
			public int compare(int a, int b) {
				return tweetMap.get(a) - tweetMap.get(b);
			}
		});
		while (feed.size() < 10) {
			int currTweet = minHeap.poll();
			feed.add(currTweet);
			minHeap.offer(currTweet.next());
		}
		return feed;
	}

	public void follow(int followerId, int followeeId) {
		if (!followMap.containsKey(followerId)) {
			followMap.put(followerId, new HashSet<>());
		}
		followMap.get(followerId).add(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followees = followMap.get(followerId);
		if (followees.contains(followeeId)) {
			followees.remove(followeeId);
		}
	}
}
