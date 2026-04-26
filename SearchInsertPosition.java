class Solution {
    public int searchInsert(int[] nums,int target) {
        int lt=0;
        int rt=nums.length-1;
        while (lt<=rt) {
            int mid=lt+(rt-lt) / 2; // avoids overflow
            if (nums[mid]==target) {
                return mid;
            } 
            else if (nums[mid]<target) {
                lt=mid+1;
            } 
            else {
                rt=mid-1;
            }
        }
        return lt; // correct insert position
    }
}
