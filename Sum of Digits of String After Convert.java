class Solution {
    public int getLucky(String s, int k) {
        int sum=0;
        // First conversion + first transform
        for(char c:s.toCharArray()) {
            int val=c-'a'+1;
            while(val>0) {
                sum+=val%10;
                val/=10;
            }
        }
        // Remaining k - 1 transforms
        while(--k>0) {
            int newSum=0;
            while(sum>0) {
                newSum+=sum%10;
                sum/=10;
            }
            sum=newSum;
        }
        return sum;
    }
}
