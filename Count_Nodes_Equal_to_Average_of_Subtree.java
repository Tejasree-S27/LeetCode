class Solution {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }
    // Returns {sum, count} for the subtree
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // Get information from left and right subtrees
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // Calculate sum and count of current subtree
        int sum = node.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];
        // Integer division automatically rounds down
        int average = sum / count;
        // Check if current node equals subtree average
        if (node.val == average) {
            result++;
        }
        return new int[]{sum, count};
    }
}
