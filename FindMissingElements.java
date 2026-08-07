import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        Set<Integer> curr=new HashSet<>();
        for(int num : nums) {
            min=Math.min(min,num);
            max=Math.max(max,num);
            curr.add(num);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=min+1;i<max;i++) {
            if(!curr.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
