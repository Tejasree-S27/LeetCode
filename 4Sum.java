import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n-3;i++) {
            // Skip duplicate first elements
            if (i>0 && nums[i]==nums[i-1]) 
            continue;
            for (int j=i+1;j<n-2;j++) {
                // Skip duplicate second elements
                if (j>i+1 && nums[j]==nums[j-1]) 
                continue;
                int lt=j+1;
                int rt=n-1;
                while (lt<rt) {
                    long sum=(long) nums[i]+nums[j]+nums[lt]+nums[rt];
                    if (sum==target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[lt],nums[rt]));
                        lt++;
                        rt--;
                        // Skip duplicates
                        while (lt<rt && nums[lt]==nums[lt-1]) {
                            lt++;
                        }
                        while (lt<rt && nums[rt]==nums[rt+1]) {
                            rt--;
                        }
                    } else if(sum<target) {
                        lt++;
                    } else {
                        rt--;
                    }
                }
            }
        }
        return result;
    }
}
