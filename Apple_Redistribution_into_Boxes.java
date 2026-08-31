class Solution {
    public int minimumBoxes(int[] apple,int[] capacity) {
        int sum=0,ans=0;
        for(int x : apple) 
        sum+=x;
        Arrays.sort(capacity);
        for(int i=capacity.length-1;i>=0 && sum>0;i--) {
            sum-=capacity[i];
            ans++;
        }
        return ans;
    }
}
