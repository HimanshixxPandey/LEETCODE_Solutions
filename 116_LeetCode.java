class Solution {
    public Node connect(Node root) {
        Queue<Node>ans=new ArrayDeque<>();
        if(root==null)
        {
            return null;
        }
        ans.add(root);
        while(ans.size()>0)
        {
           int s=ans.size();
           int t=ans.size();
            Node temp=null;
            while(s>0)
            {  Node res=ans.remove();
                if(s==t)
                {
                 temp=res;
                }
                else
                {
                 temp.next=res;
                } 
                temp=res;
               if(res.left!=null)
               {
                ans.add(res.left);
                }
               if(res.right!=null)
                {
                ans.add(res.right);
                }
            s--;
            }
        }
        return root;
        
    }
}