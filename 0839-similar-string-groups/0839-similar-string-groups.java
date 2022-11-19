class Solution {
    class DSU
    {   
     String strs[];
     DSU(String strs[])
     {
         this.strs=strs;
         par=new int[strs.length];
         rank=new int[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
     
        this.groups=strs.length;
     }
    int par[];
    int rank[];
    int groups;
    public int find(int idx)
    {
        if(par[idx]==idx)
        {
            return idx;
        }
        int leader=find(par[idx]);
        par[idx]=leader;
        return leader;
    }
   public int union(int idx1,int idx2)
   {
       int idx1l=find(idx1);
       int idx2l=find(idx2);
       if(idx1l!=idx2l && issimilar(strs,idx1,idx2))
       {
           if(rank[idx1l]>rank[idx2l])
           {
               par[idx2l]=idx1l;
           }
           else if(rank[idx2l]>rank[idx1l])
           {
               par[idx1l]=idx2l;
           }
           else
          {
           par[idx1l]=idx2l;
           rank[idx2]++;
          }
           groups--;
       }
       return groups;
   }
    public boolean issimilar(String strs[],int idx1,int idx2)
    {
        String s1=strs[idx1];
        String s2=strs[idx2];
        int i=0,j=0,c=0;
        if(s1.length()!=s2.length())
        {
            return false;
        }
        while(i<s1.length() && j<s2.length())
        {
         if(s1.charAt(i)!=s2.charAt(j))
         {
             c++;
         }
            i++;
            j++;
        }
        if(c<=2)
        {
            return true;
        }
        return false;
    }
    }
    public int numSimilarGroups(String[] strs) {
        DSU dsu=new DSU(strs);
        for(int i=0;i<strs.length;i++)
        {
            for(int j=i+1;j<strs.length;j++)
        {
            dsu.union(i,j);
        }    
        }
        
        return dsu.groups;
    }
}