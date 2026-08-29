class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans=0;
        for(String word : text.split(" ")) {
            boolean ok=true;
            for(char c : brokenLetters.toCharArray()) {
                if(word.indexOf(c)!=-1) {
                    ok=false;
                    break;
                }
            }
            if(ok) 
            ans++;
        }
        return ans;
    }
}
