class Solution {
    static class Interval {
        int left, right, weight, index;
        Interval(int left, int right, int weight, int index) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.index = index;
        }
    }
    static class Result {
        long score;
        int[] indices;
        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> cur = intervals.get(i);
            arr[i] = new Interval(cur.get(0),cur.get(1),cur.get(2),i);
        }
        // Sort by ending point
        Arrays.sort(arr, (a, b) -> {
            if (a.right != b.right) {
                return Integer.compare(a.right, b.right);
            }
            return Integer.compare(a.left, b.left);
        });
        // dp[i][k] = best result using first i intervals
        // and choosing exactly k intervals
        Result[][] dp = new Result[n + 1][5];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new Result(0, new int[0]);
        }
        for (int i = 1; i <= n; i++) {
            Interval current = arr[i - 1];
            // Find last interval whose right < current.left
            int p = findPrevious(arr, i - 1, current.left);
            for (int k = 1; k <= 4; k++) {
                // Option 1: don't choose current interval
                Result best = dp[i - 1][k];
                // Option 2: choose current interval
                if (dp[p][k - 1] != null) {
                    Result previous = dp[p][k - 1];
                    int[] newIndices = addAndSort(previous.indices, current.index);
                    Result take = new Result(
                        previous.score + current.weight, newIndices);
                    if (better(take, best)) {
                        best = take;
                    }
                }
                dp[i][k] = best;
            }
        }
        // We can choose UP TO 4 intervals
        Result answer = dp[n][0];
        for (int k = 1; k <= 4; k++) {
            if (better(dp[n][k], answer)) {
                answer = dp[n][k];
            }
        }
        return answer.indices;
    }
    private int findPrevious(
        Interval[] arr,
        int endExclusive,
        int left
    ) {
        int low = 0;
        int high = endExclusive;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].right < left) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private int[] addAndSort(int[] old, int index) {
        int[] result = Arrays.copyOf(old, old.length + 1);
        result[old.length] = index;
        Arrays.sort(result);
        return result;
    }
    private boolean better(Result a, Result b) {
        if (b == null) {
            return true;
        }
        // Higher weight is better
        if (a.score != b.score) {
            return a.score > b.score;
        }
        // Same weight -> lexicographically smaller indices
        return lexicographicallySmaller(a.indices, b.indices);
    }
    private boolean lexicographicallySmaller(int[] a, int[] b) {
        int n = Math.min(a.length, b.length);
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }
        return a.length < b.length;
    }
}
