class Solution {
    public String reorganizeString(String s) {
         int[] freq = new int[26];

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] prev = null;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            // Add current character
            result.append((char)(curr[0] + 'a'));
            curr[1]--;

            // Add previous back if still available
            if (prev != null && prev[1] > 0) {
                pq.add(prev);
            }

            // Set current as previous
            prev = curr;
        }

        // If result length != original → not possible
        if (result.length() != s.length()) return "";

        return result.toString();
    }
}