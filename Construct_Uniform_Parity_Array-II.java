class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                minOdd = Math.min(minOdd, num);
            }
        }
        // All elements already have the same parity
        if (minOdd == Integer.MAX_VALUE || 
            minEven == Integer.MAX_VALUE) {
            return true;
        }
        // Check if smallest odd is smaller than smallest even
        return minOdd < minEven;
    }
}
