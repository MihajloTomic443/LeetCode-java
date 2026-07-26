package queue.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * LeetCode 933 - Number of Recent Calls
 *
 * Idea:
 * Maintain a queue containing only the requests that occurred within
 * the last 3000 milliseconds. Every new request is added to the queue,
 * and all outdated requests are removed from the front since timestamps
 * are strictly increasing. The remaining queue size represents the
 * number of recent requests.
 *
 * Time Complexity:
 * ping() -> O(1) amortized
 *
 * Space Complexity:
 * O(n)
 *
 * Learned:
 * - Learned how to use Queue for sliding window style problems.
 * - Practiced Queue operations: offer(), poll(), peek(), size(), isEmpty().
 * - Understood why timestamps being strictly increasing allows removing
 *   outdated requests only from the front of the queue.
 * - Learned how LeetCode "Design" problems work using constructors and
 *   instance variables that preserve state across multiple method calls.
 * - Saw another example of amortized analysis: every request is added
 *   exactly once and removed at most once.
 */
public class NumberOfRecentCalls {

    public static void main(String[] args) {

        RecentCounter counter = new RecentCounter();

        System.out.println(counter.ping(1));      // 1
        System.out.println(counter.ping(100));    // 2
        System.out.println(counter.ping(3001));   // 3
        System.out.println(counter.ping(3002));   // 3
    }
}

class RecentCounter {

    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {

        queue.offer(t);

        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}