class Solution {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++) {
            res<<=1;        // Shift result left
            res|=(n&1);     // Add last bit of n
            n>>>=1;         // Unsigned right shift
        }
        return result;
    }
}
