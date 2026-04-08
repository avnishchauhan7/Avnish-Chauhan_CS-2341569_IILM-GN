class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] freq = new int[26];

        // Count frequency
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // Find max frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count how many have max frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) maxCount++;
        }

        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int result = partCount * partLength + maxCount;

        return Math.max(tasks.length, result);
    }
}