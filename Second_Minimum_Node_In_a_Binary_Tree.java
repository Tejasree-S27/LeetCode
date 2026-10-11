class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = findMin(root.left, root.val);
        int right = findMin(root.right, root.val);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }
    private int findMin(TreeNode node, int min) {
        if (node == null) {
            return -1;
        }
        if (node.val > min) {
            return node.val;
        }
        int left = findMin(node.left, min);
        int right = findMin(node.right, min);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }
}
