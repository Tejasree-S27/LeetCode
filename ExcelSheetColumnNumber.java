class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        for(char ch : columnTitle.toCharArray()) {
            res=res*26+(ch-'A'+1);
        }
        return res;
    }
}
