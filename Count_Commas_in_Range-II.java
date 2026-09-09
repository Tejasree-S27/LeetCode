class Solution {
    public long countCommas(long n) {
        long result = 0;
        long power = 1000;
        while (power <= n) {
            result += n - power + 1;
            // Move to the next comma level
            if (power > n / 1000) {
                break;
            }
            power *= 1000;
        }
        return result;
    }
}
