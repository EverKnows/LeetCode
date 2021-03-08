
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author jianmiao.xu
 * @date 2021/3/4
 */
public class Solution355 {


    private Map<Integer, LinkedList<Tweet>> twitter = new HashMap<>();

    private Map<Integer, Set<Integer>> followingMap = new HashMap<>();

    private static int timestamp = 0;

    private static PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(new Comparator<Tweet>() {

        @Override
        public int compare(Tweet o1, Tweet o2) {
            return o2.time - o1.time;
        }
    });

    class Tweet {
        public int tweetId;

        public int time;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    ///** Initialize your data structure here. */
    //public Twitter() {
    //
    //}

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (twitter.get(userId) == null) {
            LinkedList<Tweet> list = new LinkedList<>();
            list.addFirst(new Tweet(tweetId, timestamp++));
            twitter.put(userId, list);
        } else {
            twitter.get(userId).addFirst(new Tweet(tweetId, timestamp++));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (twitter.get(userId) != null) {
            maxHeap.addAll(twitter.get(userId));
        }

        if (followingMap.get(userId) != null) {
            Set<Integer> userIdSet = followingMap.get(userId);
            for (Integer fUserId : userIdSet) {
                if (twitter.get(fUserId) != null) {
                    maxHeap.addAll(twitter.get(fUserId));
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        int count = 0;

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().tweetId);
            count++;
            if (count == 10) {
                break;
            }
        }

        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        if (followingMap.get(followerId) != null) {
            followingMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followingMap.put(followerId, set);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (followingMap.get(followerId) != null) {
            if (followingMap.get(followerId).contains(followeeId)) {
                followingMap.get(followerId).remove(followeeId);
            }
        }
    }

    public static void main(String[] args) {

        Solution355 solution355 = new Solution355();
        solution355.postTweet(1, 5);
        solution355.postTweet(2, 6);
        solution355.follow(1, 2);
        System.out.println(solution355.getNewsFeed(1));
    }



}