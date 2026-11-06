import java.util.*;
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        int m = queries.length;
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        Arrays.sort(qs, Comparator.comparingInt(a -> a[0]));
        int[] freq = new int[n + 1];
        int active = 0;
        int left = 0, right = 0;
        int[] ans = new int[m];
        for (int[] q : qs) {
            int time = q[0];
            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];
                if (freq[server] == 0)
                    active++;
                freq[server]++;
                right++;
            }
            while (left < logs.length && logs[left][1] < time - x) {
                int server = logs[left][0];
                freq[server]--;
                if (freq[server] == 0)
                    active--;
                left++;
            }
            ans[q[1]] = n - active;
        }
        return ans;
    }
}
