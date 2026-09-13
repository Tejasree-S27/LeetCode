class Solution {
    public int findComplement(int num) {
        int mask = 0;
        int temp = num;
        // Create mask: 111...111
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        // Flip only the meaningful bits
        return num ^ mask;
    }
}
