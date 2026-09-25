class Solution {
    String s;
    int index;
    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;
        Set<String> result = parseExpression();
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }
    // Handles union: e1,e2,e3
    private Set<String> parseExpression() {
        Set<String> result = parseTerm();
        while (index < s.length() && s.charAt(index) == ',') {
            index++;
            result.addAll(parseTerm());
        }
        return result;
    }
    // Handles concatenation: e1e2e3
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");
        while (index < s.length() && s.charAt(index) != '}' && s.charAt(index) != ',') {
            Set<String> next = parseFactor();
            Set<String> combined = new HashSet<>();
            for (String a : result) {
                for (String b : next) {
                    combined.add(a + b);
                }
            }
            result = combined;
        }
        return result;
    }
    // Handles a letter or {...}
    private Set<String> parseFactor() {
        if (s.charAt(index) == '{') {
            index++;
            Set<String> result = parseExpression();
            index++; // skip '}'
            return result;
        }
        Set<String> result = new HashSet<>();
        result.add(String.valueOf(s.charAt(index++)));
        return result;
    }
}
