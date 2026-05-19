class Solution {
    public int climbStairs(int n) {
        if(n<=3)
        return n;
        int first=2;
        int second=1;
        int temp=0;
        for(int i=2;i<n;i++)
        {
            temp=first+second;
            second=first;
            first=temp;
        }
        return temp;
    }
}
