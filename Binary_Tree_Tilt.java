class Solution {
    int totalTilt = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return totalTilt;
    }
    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        totalTilt += Math.abs(leftSum - rightSum);
        return node.val + leftSum + rightSum;
    }
}
