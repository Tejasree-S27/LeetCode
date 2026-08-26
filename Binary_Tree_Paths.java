class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        dfs(root,"",result);
        return result;
    }
    private void dfs(TreeNode node,String path,List<String> result) {
        if(node==null) {
            return;
        }
        // Add current node to the path
        if(path.isEmpty()) {
            path=String.valueOf(node.val);
        } else {
            path+="->"+node.val;
        }
        // If it is a leaf node, add the path
        if(node.left==null && node.right==null) {
            result.add(path);
            return;
        }
        dfs(node.left,path,result);
        dfs(node.right,path,result);
    }
}
