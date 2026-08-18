class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        // Sort in ascending order
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        // Pick largest distinct elements
        for(int i=nums.length-1;i>=0 && set.size()<k;i--) {
            set.add(nums[i]);
        }
        // Convert to array
        int[] ans=new int[set.size()];
        int index=0;
        // HashSet doesn't guarantee descending order,
        // so fill the array and sort it.
        for(int num : set) {
            ans[index++]=num;
        }
        Arrays.sort(ans);
        // Reverse to descending order
        for(int i=0,j=ans.length-1;i<j;i++,j--) {
            int temp=ans[i];
            ans[i]=ans[j];
            ans[j]=temp;
        }
        return ans;
    }
}
