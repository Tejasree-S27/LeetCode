class Solution 
{
    public int maxNumberOfBalloons(String text) 
    {
        int[] chars=new int[26]; 
        for(char ch:text.toCharArray())
            chars[ch-'a']++;
        return Math.min(Math.min(chars['b'-'a'],chars['a'-'a']),
               Math.min(Math.min(chars['l'-'a']/2,chars['o'-'a']/2),chars['n'-'a']));
    }
}
