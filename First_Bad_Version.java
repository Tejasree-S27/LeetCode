public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1;
        int right=n;
        while(left<right) {
            // Avoid integer overflow
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)) {
                // mid can be the first bad version
                right=mid;
            } else {
                // First bad version must be after mid
                left=mid+1;
            }
        }
        return left;
    }
}
