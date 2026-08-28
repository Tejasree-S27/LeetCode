class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int odd = 0;
        char mid = 0;
        // Build frequency for the first half
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
            count[i] /= 2;
        }
        // Palindrome is not possible
        if (odd > 1) {
            return "";
        }
        int halfLen = s.length() / 2;
        String limit = target.substring(0, halfLen);
        // Find the smallest possible first half >= limit
        String half = findGreaterOrEqual(limit, count);
        if (half.isEmpty()) {
            return "";
        }
        String palindrome = makePalindrome(half, mid);
        // If strictly greater, return it
        if (palindrome.compareTo(target) > 0) {
            return palindrome;
        }
        // Otherwise find next greater first half
        half = findNextGreater(half);
        if (half.isEmpty()) {
            return "";
        }
        return makePalindrome(half, mid);
    }
    private String findGreaterOrEqual(String target, int[] original) {
        int[] count = original.clone();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            int x = target.charAt(i) - 'a';
            if (count[x] > 0) {
                ans.append(target.charAt(i));
                count[x]--;
            } else {
                // Try a greater character at current position
                for (int c = x + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        ans.append((char) ('a' + c));
                        count[c]--;
                        return addRemaining(ans, count);
                    }
                }
                // Backtrack
                return backtrack(ans, count, target);
            }
        }
        return ans.toString();
    }
    private String backtrack(StringBuilder ans, int[] count, String target) {
        for (int i = ans.length() - 1; i >= 0; i--) {
            count[ans.charAt(i) - 'a']++;
            ans.deleteCharAt(i);
            int x = target.charAt(i) - 'a';
            for (int c = x + 1; c < 26; c++) {
                if (count[c] > 0) {
                    ans.append((char) ('a' + c));
                    count[c]--;
                    return addRemaining(ans, count);
                }
            }
        }
        return "";
    }
    private String addRemaining(StringBuilder ans, int[] count) {
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ans.append((char) ('a' + i));
                count[i]--;
            }
        }
        return ans.toString();
    }
    private String findNextGreater(String s) {
        char[] a = s.toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i < 0) {
            return "";
        }
        int j = a.length - 1;
        while (a[j] <= a[i]) {
            j--;
        }
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        reverse(a, i + 1, a.length - 1);
        return new String(a);
    }
    private void reverse(char[] a, int left, int right) {
        while (left < right) {
            char temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
    }
    private String makePalindrome(String half, char mid) {
        StringBuilder ans = new StringBuilder(half);
        if (mid != 0) {
            ans.append(mid);
        }
        ans.append(new StringBuilder(half).reverse());
        return ans.toString();
    }
}
