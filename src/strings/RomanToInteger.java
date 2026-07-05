package strings;

import java.util.HashMap;
import java.util.Map;

/*
LeetCode #13 - Roman to Integer

Difficulty: Easy
Topic: Strings, HashMap

Time Complexity: O(n)
Space Complexity: O(1)

Idea:
Store each Roman numeral and its value in a HashMap.
Traverse the string from left to right.
If the current symbol is smaller than the next one,
subtract it from the next value and skip the next character.
Otherwise, simply add the current value.

Learned:
- Access characters in a String using charAt().
- Use HashMap to map Roman symbols to integer values.
- Handle edge cases before accessing the next character.
- Skip already processed symbols using i++.

Solved: 2026-07-06
*/

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));

            if (i == s.length() - 1) {
                sum += current;
            } else if (current < map.get(s.charAt(i + 1))) {
                sum += map.get(s.charAt(i + 1)) - current;
                i++;
            } else {
                sum += current;
            }
        }

        return sum;
    }
}
