import java.util.*;
class Solution {
    public int countLargestGroup(int n) {
        int[] count=new int[37];
        for(int i=1;i<=n;i++) {
            int sum=0;
            int x=i;
            while(x>0) {
                sum+=x%10;
                x/=10;
            }
            count[sum]++;
        }
        int max=0,ans=0;
        for(int x : count) 
            max=Math.max(max,x);
        for(int x : count) {
            if(x==max) {
                ans++;
            }
        }
        return ans;
    }
}
