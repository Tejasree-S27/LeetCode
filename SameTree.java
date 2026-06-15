class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null
        if (p==null && q==null) {
            return true;
        }
        // One is null or values differ
        if (p==null || q==null || p.val!=q.val) {
            return false;
        }
        // Check left and right subtrees
        return isSameTree(p.left,q.left)
            && isSameTree(p.right,q.right);
    }
}
