class Solution {
    public int strStr(String haystack, String needle) {
        int x=haystack.length();
        int y=needle.length();
        for (int i=0;i<=x-y;i++) {
            int j=0;
            while(j<y && haystack.charAt(i+j)==needle.charAt(j)) {
                j++;
            }
            if (j==y) 
            return i;  
        }
        return -1;
    }
}
