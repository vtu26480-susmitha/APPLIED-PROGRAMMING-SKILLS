import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] count = new int[26];

        // Store frequency of characters in p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, required = p.length();

        while (right < s.length()) {

            // If current character is needed
            if (count[s.charAt(right) - 'a'] > 0) {
                required--;
            }

            count[s.charAt(right) - 'a']--;
            right++;

            // If window size equals p length
            if (right - left == p.length()) {

                if (required == 0) {
                    result.add(left);
                }

                // Move left pointer
                if (count[s.charAt(left) - 'a'] >= 0) {
                    required++;
                }

                count[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;
    }
}