class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
         List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int v = curr[1];
            int j = curr[2];

            result.add(Arrays.asList(u, v));
            if (j + 1 < nums2.length) {
                pq.add(new int[]{u, nums2[j + 1], j + 1});
            }
        }

        return result;
    }
}