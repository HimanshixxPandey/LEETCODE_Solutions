class Solution {
    class pair{
        int sum;
        int size;
        pair(int sum,int size)
        {
            this.sum=sum;
            this.size=size;
        }
    }
    int ans=0;
     pair helper(TreeNode root)
    {
        if(root==null)
        {
            return (new pair(0,0));
        }
      pair leftsum=helper(root.left);
      pair rightsum=helper(root.right);
      int currsum=root.val+leftsum.sum+rightsum.sum;
      int currsize=1+leftsum.size+rightsum.size;
        if(currsum/currsize==root.val)
        {
            ans++;
        }
        
     return new pair(currsum,currsize);
        
        
    }
    public int averageOfSubtree(TreeNode root) {
     helper(root);
        return ans;
    }
}