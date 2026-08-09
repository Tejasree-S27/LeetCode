import java.util.*;
class Solution {
    public String longestNiceSubstring(String s) {
        String ans="";
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<=s.length();j++) {
                String sub=s.substring(i,j);
                if(isNice(sub) && sub.length()>ans.length()) {
                    ans=sub;
                }
            }
        }
        return ans;
    }
    public boolean isNice(String str) {
        HashSet<Character> set=new HashSet<>();
        // Store all characters
        for(char ch : str.toCharArray()) {
            set.add(ch);
        }
        // Check uppercase/lowercase pair
        for(char ch : str.toCharArray()) {
            if(Character.isLowerCase(ch)) {
                if(!set.contains(Character.toUpperCase(ch))) {
                    return false;
                }
            } else {
                if(!set.contains(Character.toLowerCase(ch))) {
                    return false;
                }
            }
        }
        return true;
    }
}
