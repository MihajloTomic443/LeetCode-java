package queue.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * LeetCode 649 - Dota2 Senate
 * Difficulty: Medium
 * Topic: Queue
 *
 * Time Complexity:
 * - O(n)
 *
 * Space Complexity:
 * - O(n)
 *
 * Idea:
 * - Use two queues to store the indices of Radiant and Dire senators.
 * - The senator with the smaller index acts first and bans the first senator
 *   from the opposing party.
 * - The surviving senator is added back to the end of their queue with
 *   index + n, simulating the next round of voting.
 * - Continue until one party has no senators remaining.
 *
 * Learned:
 * - Queues can efficiently simulate cyclic processes.
 * - Storing indices is often more useful than storing values.
 * - Adding +n preserves the correct order across multiple rounds.
 *
 * Solved: 2026-07-26
 */
public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                queueR.offer(i);
            } else {
                queueD.offer(i);
            }
        }

        while (!queueR.isEmpty() && !queueD.isEmpty()) {
            if (queueR.peek() < queueD.peek()) {
                queueD.poll();
                queueR.offer(queueR.poll() + n);
            } else {
                queueR.poll();
                queueD.offer(queueD.poll() + n);
            }
        }

        if (queueR.isEmpty()) {
            return "Dire";
        }

        return "Radiant";
    }
}