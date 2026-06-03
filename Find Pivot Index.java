class Solution 
{
    public int pivotIndex(int[] nums) 
    {
        for(int i=0;i<nums.length;i++) 
        {
            int lt=0;
            int rt=0;
            for(int j=0;j<i;j++) 
                lt+=nums[j];
            for(int j=i+1;j<nums.length;j++) 
                rt+= nums[j];
            if(lt==rt)
                return i;
        }
        return -1;
    }
}
