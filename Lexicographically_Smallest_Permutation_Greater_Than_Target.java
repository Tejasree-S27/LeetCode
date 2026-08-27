class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int x = target.charAt(i) - 'a';
            // First try to match target
            if (freq[x] > 0) {
                ans.append(target.charAt(i));
                freq[x]--;
                continue;
            }
            // Cannot match, try greater character here
            for (int c = x + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    ans.append((char) ('a' + c));
                    freq[c]--;
                    return addRemaining(ans, freq);
                }
            }
            // Backtrack
            return backtrack(ans, freq, target);
        }
        // Exact target was formed, so backtrack
        return backtrack(ans, freq, target);
    }
    private String backtrack(StringBuilder ans, int[] freq, String target) {
        for (int i = ans.length() - 1; i >= 0; i--) {
            freq[ans.charAt(i) - 'a']++;
            ans.deleteCharAt(i);
            int x = target.charAt(i) - 'a';
            for (int c = x + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    ans.append((char) ('a' + c));
                    freq[c]--;
                    return addRemaining(ans, freq);
                }
            }
        }
        return "";
    }
    private String addRemaining(StringBuilder ans, int[] freq) {
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0)
                ans.append((char) ('a' + i));
        }
        return ans.toString();
    }
}
