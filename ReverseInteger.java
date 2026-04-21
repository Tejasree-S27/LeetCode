class Solution {
    public int reverse(int x) {
        int revs=0;
        while(x!=0) {
            int d=x%10;
            x=x/10;
            if(revs>Integer.MAX_VALUE/10 || (revs==Integer.MAX_VALUE/10 && d>7)) {
                return 0;
            }
            if(revs<Integer.MIN_VALUE/10 || (revs==Integer.MIN_VALUE/10 && d<-8)) {
                return 0;
            }
            revs=revs*10+d;
        }
        return revs;
    }
}
