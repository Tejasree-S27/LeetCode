class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        // If left child is null, recurse on right subtree
        if(root.left==null) {
            return 1+minDepth(root.right);
        }
        // If right child is null, recurse on left subtree
        if(root.right==null) {
            return 1+minDepth(root.left);
        }
        // Both children exist
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}
