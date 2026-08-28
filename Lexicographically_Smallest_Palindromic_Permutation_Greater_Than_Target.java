class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] count=new int[26];
        // Count characters
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }
        int odd=0;
        char mid=0;
        // Check whether a palindromic permutation is possible
        for(int i=0;i<26;i++) {
            if(count[i]%2==1) {
                odd++;
                mid=(char)('a'+i);
            }
            count[i] /= 2;
        }
        // Palindrome is impossible
        if(odd!=s.length()%2) {
            return "";
        }
        int halfLength=s.length()/2;
        String firstHalf=target.substring(0,halfLength);
        // Check if target's first half can be formed
        if(canMake(firstHalf,count)) {
            String palindrome=makePalindrome(firstHalf,mid);
            // If palindrome is strictly greater
            if(palindrome.compareTo(target)>0) {
                return palindrome;
            }
        }
        // Find the smallest available half greater than target's first half
        String greaterHalf=findGreater(firstHalf,count);
        if(greaterHalf.isEmpty()) {
            return "";
        }
        return makePalindrome(greaterHalf,mid);
    }
    // Check whether str can be formed using count
    private boolean canMake(String str,int[] count) {
        int[] temp=count.clone();
        for(char c : str.toCharArray()) {
            int index=c-'a';
            if(temp[index]==0) {
                return false;
            }
            temp[index]--;
        }
        return true;
    }
    // Find lexicographically smallest permutation greater than target
    private String findGreater(String target,int[] original) {
        int[] count=original.clone();
        StringBuilder ans=new StringBuilder();
        // Try to match target
        for(int i=0;i<target.length();i++) {
            int x=target.charAt(i)-'a';
            if(count[x]>0) {
                ans.append(target.charAt(i));
                count[x]--;
            } else {
                return backtrack(ans,count,target);
            }
        }
        // Exact match, so find next greater permutation
        return backtrack(ans,count,target);
    }
    private String backtrack(StringBuilder ans,int[] count,String target) {
        for(int i=ans.length()-1;i>=0;i--) {
            // Put character back
            count[ans.charAt(i)-'a']++;
            ans.deleteCharAt(i);
            int current=target.charAt(i)-'a';
            // Find smallest character greater than target[i]
            for(int c=current+1;c<26;c++) {
                if(count[c]>0) {
                    ans.append((char)('a'+c));
                    count[c]--;
                    // Add remaining characters in sorted order
                    for(int j=0;j<26;j++) {
                        while(count[j]>0) {
                            ans.append((char)('a'+j));
                            count[j]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
    }
    // Create palindrome from first half
    private String makePalindrome(String half,char mid) {
        StringBuilder result=new StringBuilder(half);
        if(mid!=0) {
            result.append(mid);
        }
        result.append(new StringBuilder(half).reverse());
        return result.toString();
    }
}
