class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length-1;
        int[] count=new int[n+1];
        for(int x : nums) {
            if(x<1 || x>n || ++count[x]>2)
                return false;
        }
        for(int i=1;i<n;i++)
            if(count[i]!=1)
                return false;
        return count[n]==2;
    }
}
