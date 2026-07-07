class Solution {
    public long sumAndMultiply(int n) {
        long x=0;
        int sum=0;
        String str=String.valueOf(n);
        for(char c : str.toCharArray()) {
            if(c!='0') {
                int dig=c-'0';
                x=x*10+dig;
                sum+=dig;
            }
        }
        return x*sum;
    }
}
