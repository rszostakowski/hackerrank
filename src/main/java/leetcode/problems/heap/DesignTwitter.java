package leetcode.problems.heap;
import java.util.*;
import java.util.stream.Collectors;


// I am not very proud of myself with this solution.
public class DesignTwitter {
    public static void main2(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

    //["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
    //[[],[1,1],[1],[2,1],[2],[2,1],[2]]
    public static void main3(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
    }

    //["Twitter","postTweet","follow","follow","getNewsFeed"]
    //[[],[2,5],[1,2],[1,2],[1]]
    public static void main14(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(2, 5);
        twitter.follow(1, 2);
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

    // ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
    // [[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]

    public static void main12(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);
        System.out.println(twitter.getNewsFeed(1));
    }

    //,"getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
    //,[1],[2],[1,2],[1],[2]]
    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
    }

        private static final int MAX_FEED_SIZE = 10;

        private int tweetCounter;
        private Map<Integer, PriorityQueue<Tweet>> userTweets;
        private Map<Integer, Set<Integer>> userFollows;

        public DesignTwitter() {
            tweetCounter = 0;
            userTweets = new HashMap<>();
            userFollows = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetCounter++;
            userTweets.computeIfAbsent(userId, u -> new PriorityQueue<>(MAX_FEED_SIZE))
                    .add(new Tweet(tweetId, tweetCounter));
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> feed = new PriorityQueue<>(MAX_FEED_SIZE, Collections.reverseOrder());
            feed.addAll(userTweets.getOrDefault(userId, new PriorityQueue<>()));

            List<Integer> result = new ArrayList<>();
            while (!feed.isEmpty() && result.size() < MAX_FEED_SIZE) {
                result.add(feed.poll().tweetId);
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            userFollows.computeIfAbsent(followerId, f -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            userFollows.computeIfPresent(followerId, (f, follows) -> {
                follows.remove(followeeId);
                return follows;
            });
        }
    }

class Tweet implements Comparable<Tweet> {
    int tweetId;
    int tweetTime;

    public Tweet(int tweetId, int tweetTime) {
        this.tweetId = tweetId;
        this.tweetTime = tweetTime;
    }

    @Override
    public int compareTo(Tweet other) {
        return Integer.compare(this.tweetTime, other.tweetTime);
    }
}