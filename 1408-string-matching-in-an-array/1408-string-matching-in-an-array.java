import java.util.*;

public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words1 = {"mass","as","hero","superhero"};
        System.out.println(sol.stringMatching(words1)); 
        String[] words2 = {"leetcode","et","code"};
        System.out.println(sol.stringMatching(words2)); 
           String[] words3 = {"blue","green","bu"};
        System.out.println(sol.stringMatching(words3)); 
    }
}