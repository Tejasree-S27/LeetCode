class Solution {
    int k;
    Node[] tree;
    class Node {
        int product;
        long[] pre;
        Node() {
            pre = new long[k];
        }
    }
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1, nums);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            update(1, 0, n - 1, index, value % k);
            Node res = query(1, 0, n - 1, start, n - 1);
            ans[i] = (int) res.pre[x];
        }
        return ans;
    }
    private Node create(int value) {
        Node node = new Node();
        node.product = value % k;
        node.pre[node.product] = 1;
        return node;
    }
    private Node merge(Node left, Node right) {
        Node res = new Node();
        // Product of the whole segment
        res.product = (int) ((long) left.product * right.product % k);
        // Prefixes entirely inside left
        for (int r = 0; r < k; r++) {
            res.pre[r] += left.pre[r];
        }
        // Prefixes that contain all of left + a prefix of right
        for (int r = 0; r < k; r++) {
            int newRemainder =
                    (int) ((long) left.product * r % k);

            res.pre[newRemainder] += right.pre[r];
        }
        return res;
    }
    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node] = create(nums[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
    private void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node] = create(value);
            return;
        }
        int mid = (l + r) / 2;
        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
    private Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }
        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);
        return merge(left, right);
    }
}
