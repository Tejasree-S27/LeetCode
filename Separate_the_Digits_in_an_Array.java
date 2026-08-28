class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int num : nums) {
            String str=String.valueOf(num);
            for(char c : str.toCharArray()) {
                res.add(c-'0');
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++) {
            ans[i]=res.get(i);
        }
        return ans;
    }
}
