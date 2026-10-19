class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            first.putIfAbsent(x, i);
            last.put(x, i);
            degree = Math.max(degree, freq.get(x));
        }
        int minLength = nums.length;
        for (int x : freq.keySet()) {
            if (freq.get(x) == degree) {
                minLength = Math.min(minLength,
                    last.get(x) - first.get(x) + 1);
            }
        }
        return minLength;
    }
}
