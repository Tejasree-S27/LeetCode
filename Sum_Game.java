class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int leftSum=0,rightSum=0;
        int leftQ=0,rightQ=0;
        for(int i=0;i<n;i++) {
            char ch=num.charAt(i);
            if(i<n/2) {
                if(ch=='?') {
                    leftQ++;
                } else {
                    leftSum+=ch-'0';
                }
            } else {
                if(ch=='?') {
                    rightQ++;
                } else {
                    rightSum+=ch-'0';
                }
            }
        }
        // Total number of '?' is odd
        // Alice gets the advantage
        if((leftQ+rightQ)%2==1) {
            return true;
        }
        // Check whether Bob can make both halves equal
        return leftSum-rightSum!=(rightQ-leftQ)*9/2;
    }
}
