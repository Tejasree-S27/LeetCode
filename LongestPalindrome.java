class Solution {
    public int longestPalindrome(String s) {
        int[] freq=new int[128];
        for(char c:s.toCharArray())
            freq[c]++;
        int len=0;
        boolean odd=false;
        for(int count:freq)
        {
            if(count%2==0)
                len += count;
            else 
            {
                len+=count-1;
                odd=true;
            }
        }
        if(odd)
            len++;
        return len;
    }
}
