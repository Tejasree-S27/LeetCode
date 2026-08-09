class Solution {
    public int lengthLongestPath(String input) {
        String[] arr=input.split("\n");
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        int max=0;
        for(String s : arr) {
            int level=s.lastIndexOf("\t")+1;
            int len=s.length()-level;
            if(s.contains(".")) {
                max=Math.max(max,map.get(level)+len);
            }
            else {
                map.put(level+1,map.get(level)+len+1);
            }
        }
        return max;
    }
}
