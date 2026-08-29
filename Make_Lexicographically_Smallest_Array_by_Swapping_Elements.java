class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int start = 0;
        while (start < n) {
            int end = start;
            // Find a group where adjacent sorted elements differ <= limit
            while (end + 1 < n && sorted[end + 1] - sorted[end] <= limit) {
                end++;
            }
            Queue<Integer> group = new LinkedList<>();
            for (int i = start; i <= end; i++) {
                group.offer(sorted[i]);
            }
            for (int i = start; i <= end; i++) {
                map.put(sorted[i], group);
            }
            start = end + 1;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = map.get(nums[i]).poll();
        }
        return nums;
    }
}
