import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }

            map.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));   
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));  
    }
}