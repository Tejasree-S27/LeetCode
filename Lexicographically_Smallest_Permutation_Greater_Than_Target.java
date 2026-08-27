class Solution {
    public String lexicographicallySmallest(String s, String target) {
        int n=s.length();
        int[] freq=new int[26];
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        char[] result=new char[n];
        // Try to match target from left to right
        for(int i=0;i<n;i++) {
            int current=target.charAt(i)-'a';
            if(freq[current]>0) {
                result[i]=target.charAt(i);
                freq[current]--;
            } else {
                // Cannot continue matching target
                return buildGreater(result,freq,target,i);
            }
        }
        // We matched target exactly.
        // Need the next lexicographically greater permutation.
        return buildGreater(result,freq,target,n);
    }
    private String buildGreater(char[] result,int[] freq,String target,int length) {
        // Go backwards and restore characters
        for(int i=length-1;i>=0;i--) {
            // Put back the character used at this position
            freq[result[i]-'a']++;
            int current=target.charAt(i)-'a';
            // Find the smallest available character greater than target[i]
            for(int c=current+1;c<26;c++) {
                if(freq[c]>0) {
                    result[i]=(char)('a'+c);
                    freq[c]--;
                    // Fill remaining positions with smallest characters
                    StringBuilder answer=new StringBuilder();
                    for(int j=0;j<=i;j++) {
                        answer.append(result[j]);
                    }
                    for(int j=0;j<26;j++) {
                        while (freq[j]-->0) {
                            answer.append((char)('a'+j));
                        }
                    }
                    return answer.toString();
                }
            }
        }
        return "";
    }
}
