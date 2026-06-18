class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }
    private void preorder(TreeNode node) {
        if(node==null) {
            return;
        }
        result.add(node.val);   // Root
        preorder(node.left);    // Left
        preorder(node.right);   // Right
    }
}
