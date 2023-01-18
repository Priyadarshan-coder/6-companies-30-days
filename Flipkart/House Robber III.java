class Solution {
    private int helper(TreeNode root,HashMap<TreeNode,Integer>map)
    {
        if(root==null)return 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        int sum=root.val;
        if(root.left!=null)
        {
            sum+=helper(root.left.left,map);
            sum+=helper(root.left.right,map);
        }
        if(root.right!=null)
        {
            sum+=helper(root.right.left,map);
            sum+=helper(root.right.right,map);
        }
        int add=helper(root.left,map)+helper(root.right,map);
        int ans=Math.max(add,sum);
         map.put(root,ans);
         return ans;
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer>map=new HashMap<>();
       return  helper(root,map);
    }
}