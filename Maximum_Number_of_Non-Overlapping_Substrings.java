class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (first[index] == -1) {
                first[index] = i;
            }
            last[index] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        // Try to create the smallest valid interval
        // starting at the first occurrence of each character.
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) {
                continue;
            }
            int start = first[c];
            int end = last[c];
            boolean valid = true;
            for (int i = start; i <= end; i++) {
                int current = s.charAt(i) - 'a';
                // This character appeared before our start.
                // Therefore we cannot make a valid substring
                // starting here.
                if (first[current] < start) {
                    valid = false;
                    break;
                }
                // We must include all occurrences of this character.
                end = Math.max(end, last[current]);
            }
            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }
        // Sort by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> result = new ArrayList<>();
        int previousEnd = -1;
        // Greedy interval selection
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start > previousEnd) {
                result.add(s.substring(start, end + 1));
                previousEnd = end;
            }
        }
        return result;
    }
}
