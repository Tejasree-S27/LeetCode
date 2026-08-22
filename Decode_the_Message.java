class Solution {
    public String decodeMessage(String key, String message) {
        char[] map=new char[26];
        boolean[] visited=new boolean[26];
        char current='a';
        // Build the substitution map
        for(char ch : key.toCharArray()) {
            if(ch!=' ' && !visited[ch-'a']) {
                map[ch-'a']=current;
                visited[ch-'a']=true;
                current++;
            }
        }
        // Decode the message
        StringBuilder result=new StringBuilder();
        for(char ch : message.toCharArray()) {
            if(ch==' ') {
                result.append(' ');
            } else {
                result.append(map[ch-'a']);
            }
        }
        return result.toString();
    }
}
