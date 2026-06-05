class Solution 
{
    public String mostCommonWord(String paragraph,String[] banned) 
    {
        paragraph=paragraph.toLowerCase().replaceAll("[^a-z ]", " ");
        Set<String> ban=new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> map=new HashMap<>();
        String ans= "";
        int max=0;
        for(String w:paragraph.split("\\s+")) 
        {
            if(!ban.contains(w)) {
                map.put(w,map.getOrDefault(w,0)+1);
                if(map.get(w)>max) {
                    max=map.get(w);
                    ans=w;
                }
            }
        }
        return ans;
    }
}
