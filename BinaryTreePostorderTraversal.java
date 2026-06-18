class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return result;
    }
    private void postorder(TreeNode node) {
        if(node==null) {
            return;
        }
        postorder(node.left);     // Left
        postorder(node.right);    // Right
        result.add(node.val);     // Root
    }
}
