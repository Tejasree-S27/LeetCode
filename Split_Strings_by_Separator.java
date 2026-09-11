class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            StringBuilder current = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (ch == separator) {
                    // Add only non-empty strings
                    if (current.length() > 0) {
                        result.add(current.toString());
                        current.setLength(0);
                    }
                } else {
                    current.append(ch);
                }
            }
            // Add the last part
            if (current.length() > 0) {
                result.add(current.toString());
            }
        }
        return result;
    }
}
