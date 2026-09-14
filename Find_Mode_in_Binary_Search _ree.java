class Solution {
    List<Integer> result = new ArrayList<>();
    Integer prev = null;
    int count = 0;
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        // Left
        inorder(node.left);
        // Current
        if (prev != null && prev == node.val) {
            count++;
        } else {
            count = 1;
        }
        prev = node.val;
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(node.val);
        } else if (count == maxCount) {
            result.add(node.val);
        }
        // Right
        inorder(node.right);
    }
}
