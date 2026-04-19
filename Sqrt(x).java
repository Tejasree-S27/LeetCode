public class Solution {
    public int mySqrt(int x) {
        // Handle edge cases for 0 and 1
        if (x<2) {
            return x;
        }
        int l=1,r=x/2;
        int ans=0;
        while (l<=r) {
            // Use (left + right) / 2 carefully to avoid integer overflow
            int mid=l+(r-l)/2;
            // Check if mid * mid <= x using long to prevent overflow
            long square=(long)mid*mid;
            if (square==x) {
                return mid; // Exact square root found
            } else if (square<x) {
                ans=mid;    // Potential answer, keep searching in the right half
                l=mid+1;
            } else {
                r=mid-1; // Square is too large, search in the left half
            }
        }
        return ans;
    }
}
