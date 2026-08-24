class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums)
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        Integer[] a = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(a, (x, y) ->
            freq.get(x) != freq.get(y)
            ? freq.get(x) - freq.get(y)
            : y - x
        );
        for (int i = 0; i < nums.length; i++)
            nums[i] = a[i];

        return nums;
    }
}
