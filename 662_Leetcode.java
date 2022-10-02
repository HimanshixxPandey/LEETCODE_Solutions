class Solution {
    class pair
    {
        TreeNode node;
        int idx;
        pair(TreeNode node,int idx)
        {
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair>ans=new ArrayDeque<>();
        int res=1;
        ans.add(new pair(root,1));
        while(ans.size()>0)
        {    
            int s=ans.size();
            int t=ans.size();
            int first=0;
            int last=0;
            while(s>0)
            {   
            pair temp=ans.remove();
             int id=temp.idx;
                if(s==t)
                {
                    first=id;
                }
             if(s==1)
             {
                 last=id;
             }
             if(temp.node.left!=null)
             {
             ans.add(new pair(temp.node.left,id*2));
             }
             if(temp.node.right!=null)
             {
             ans.add(new pair(temp.node.right,id*2+1));
             }
             s--;
              }
            int width=last-first+1;
            res=Math.max(res,width);
            
        }
        return res;
        
    }
}