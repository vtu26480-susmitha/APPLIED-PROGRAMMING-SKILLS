class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // count frequency
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // find maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // count how many tasks have max frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq)
                maxCount++;
        }

        // apply formula
        int partCount = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, partCount);
    }
}