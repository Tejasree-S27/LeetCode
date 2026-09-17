class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        int complement = k - node.val;
        if (set.contains(complement)) {
            return true;
        }
        set.add(node.val);
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}
