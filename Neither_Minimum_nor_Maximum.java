import java.util.Arrays;
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length<=2) {
            return -1;
        }
        int[] subarr={nums[0], nums[1],nums[2]};
        Arrays.sort(subarr);
        return subarr[1];
    }
}
