class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        // Count how many arrays contain each number
        for (int[] arr : nums) {
            for (int num : arr) {
                count[num]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        // Number must appear in every array
        for (int i = 1; i <= 1000; i++) {
            if (count[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }
}
