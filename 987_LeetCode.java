class Solution {
    class pair{
        TreeNode node;
        int level;
        pair(TreeNode node,int level)
        {
            this.node=node;
            this.level=level;
        }
    }
   List<List<Integer>>createmap(HashMap<Integer,ArrayList<Integer>>map)
   {
       List<List<Integer>> ans=new ArrayList<>();
       int min=Integer.MAX_VALUE;
       int max=Integer.MIN_VALUE;
       for(int vl:map.keySet())
       {
           min=Math.min(min,vl);
           max=Math.max(max,vl);
       }
       while(min<=max)
       {
           ArrayList<Integer>temp=new ArrayList<>();
           temp=map.get(min);
           ans.add(temp);
           min++;
           
       }
       return ans;
   }
    void merge( HashMap<Integer,ArrayList<Integer>>map,  HashMap<Integer,ArrayList<Integer>>temp)
    {
        for(int v:temp.keySet())
        {
            ArrayList<Integer>t=temp.get(v);
            ArrayList<Integer>mq=map.get(v);
            if(mq==null)
            {
                mq=new ArrayList<>();
                map.put(v,mq);
            }
        Collections.sort(t);
           for(int vl:t)
           {
               mq.add(vl);
           }
        }    
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        Queue<pair>mq=new ArrayDeque<pair>();
        mq.add(new pair(root,0));
        while(mq.size()>0)
        {
            int size=mq.size();
            HashMap<Integer,ArrayList<Integer>>temp=new HashMap<>();
            while(size--!=0)
            {
                pair rem=mq.remove();
                if(rem.node.left!=null)
                {
                    mq.add(new pair(rem.node.left,rem.level-1));
                }
                if(rem.node.right!=null)
                {
                    mq.add(new pair(rem.node.right,rem.level+1));
                }
                ArrayList<Integer>tempres=temp.get(rem.level);
                if(tempres==null)
                {
                    tempres=new ArrayList<>();
                    temp.put(rem.level,tempres);
                }
                tempres.add(rem.node.val);
            }
            merge(map,temp);
        }
        return createmap(map);
    }
}