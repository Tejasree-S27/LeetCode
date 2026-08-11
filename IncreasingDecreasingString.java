import java.util.*;
class Solution {
    public String sortString(String s) {
        int[] count=new int[26];
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        while(ans.length()<s.length()) {
            for(int i=0;i<26;i++) {
                if(count[i]>0) {
                    ans.append((char)('a'+i));
                    count[i]--;
                }
            }
            for(int i=25;i>=0;i--) {
                if(count[i]>0) {
                    ans.append((char)('a'+i));
                    count[i]--;
                }
            }
        }
        return ans.toString();
    }
}
