class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //base case
        if( p == null && q == null)
            return true;
        if(p == null || q == null){
            return false;
        }
        
        //checking if both right and left nodes are equal as well as the root
        if(p != null && q != null){
            return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
        
    }
}