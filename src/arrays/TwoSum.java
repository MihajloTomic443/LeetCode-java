package arrays;

import java.util.HashMap;
import java.util.Map;

/*
LeetCode #1 - Two sum
Difficulty: Easy
Topic: HashMap
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
Store visited numbers in HashMap where
key = number
value = index.
If target-current exists in map,
return indices.

Learned:
- HashMap lookup is O(1)
- Store value->index mapping
- Check before insert to avoid using same element twice

Solved: 2026-07-06
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int potreban = target - nums[i];
            if(map.containsKey(potreban)){
                return new int[]{i, map.get(potreban)};
            }
            map.put(nums[i],i);

        }
        return null;
    }
}
