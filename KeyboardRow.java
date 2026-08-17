import java.util.*;
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> r1=setOf("qwertyuiop");
        Set<Character> r2=setOf("asdfghjkl");
        Set<Character> r3=setOf("zxcvbnm");
        List<String> res=new ArrayList<>();
        for(String w : words) {
            if(canBeTyped(w,r1) || canBeTyped(w,r2) || canBeTyped(w,r3)) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }
    private boolean canBeTyped(String word,Set<Character> row) {
        for(char c : word.toLowerCase().toCharArray()) {
            if(!row.contains(c)) {
                return false;
            }
        }
        return true;
    }
    private Set<Character> setOf(String s) {
        Set<Character> set=new HashSet<>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
