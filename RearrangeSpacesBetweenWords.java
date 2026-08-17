class Solution {
    public String reorderSpaces(String text) {
        String[] w=text.trim().split("\\s+");
        int s=text.length()-text.replace(" ","").length();
        if(w.length==1) 
        return w[0] + " ".repeat(s);
        int gap=s/(w.length-1);
        int extra=s%(w.length-1);
        return String.join(" ".repeat(gap), w) + " ".repeat(extra);
    }
}
