class Solution {
    public boolean hasMatch(String s, String p) {
        int star=p.indexOf('*');
        String prefix=p.substring(0,star);
        String suffix=p.substring(star+1);
        for(int i=0;i<=s.length()-prefix.length();i++) {
            if(s.startsWith(prefix,i)) {
                int start=i+prefix.length();
                for(int j=start;j<=s.length()-suffix.length();j++) {
                    if(s.startsWith(suffix, j)) 
                        return true;
                }
            }
        }
        return false;
    }
}
