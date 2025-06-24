
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
Design Logger Rate Limiter
// Logger Rate Limiter implementation in Java
// The Logger should print a message at most once every 10 seconds for the same message.

import java.util.HashMap;
import java.util.Map;

class Logger {
    // Map to store message and the last printed timestamp
    private Map<String, Integer> messageTimestamp;

    /** Initialize your data structure here. */
    public Logger() {
        messageTimestamp = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamp.containsKey(message)) {
            // Message not seen before, print and record timestamp
            messageTimestamp.put(message, timestamp);
            return true;
        }
        int lastTimestamp = messageTimestamp.get(message);
        if (timestamp - lastTimestamp >= 10) {
            // More than 10 seconds since last print, print and update timestamp
            messageTimestamp.put(message, timestamp);
            return true;
        }
        // Less than 10 seconds, do not print
        return false;
    }}
    //
    https:// youtu.be/qtgPsgzG_po

Beautiful Arrangement
    // Beautiful Arrangement implementation in Java
    // Problem: Given an integer n, count the number of beautiful arrangements that
    // you can construct.
    // An arrangement is beautiful if for every position i (1 <= i <= n), either
    // the number at the ith position is divisible by i or i is divisible by the
    // number at the ith position.

    class Solution {
        private int count = 0;

        public int countArrangement(int n) {
            boolean[] used = new boolean[n + 1];
            backtrack(n, 1, used);
            return count;
        }

        private void backtrack(int n, int pos, boolean[] used) {
            if (pos > n) {
                count++;
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                    used[i] = true;
                    backtrack(n, pos + 1, used);
                    used[i] = false;
                }
            }
        }
}
