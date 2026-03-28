import java.util.*;

class Solution {

    public String findTheString(int[][] lcp) {

        int n = lcp.length;
        char[] word = new char[n];

        Arrays.fill(word, '#');

        char ch = 'a';

        // Step 1: build smallest string
        for (int i = 0; i < n; i++) {

            if (word[i] == '#') {

                if (ch > 'z') return "";

                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = ch;
                    }
                }
                ch++;
            }
        }

        // Step 2: verify LCP matrix
        int[][] check = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (word[i] == word[j]) {
                    check[i][j] = 1;
                    if (i + 1 < n && j + 1 < n)
                        check[i][j] += check[i + 1][j + 1];
                } else {
                    check[i][j] = 0;
                }
            }
        }

        // Step 3: compare matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(word);
    }
}