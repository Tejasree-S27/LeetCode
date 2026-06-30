class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int c=0;
        for (String p:patterns) {
            if (word.contains(p)) {
                c++;
            }
        }
        return c;
    }
}
