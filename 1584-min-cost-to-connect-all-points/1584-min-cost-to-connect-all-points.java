class Solution {
    class node{
        int u;
        int v;
        int w;
        node(int u,int v,int w)
        {
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    int par[];
    int rank[];
    int find(int mem)
    {
        if(par[mem]==mem)
        {
            return mem;
        }
        int leader=find(par[mem]);
        par[mem]=leader;
        return leader;
    }
    public void union(int x,int y)
    {
        int xl=find(x);
        int yl=find(y);
        if(xl!=yl)
        {
            if(rank[xl]>rank[yl])
            {
                par[yl]=xl;
            }
            else if(rank[yl]>rank[xl])
            {
                par[xl]=yl;
            }
            else
            {
                par[xl]=yl;
                rank[yl]++;
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<node>adj=new ArrayList<>();
        int v=points.length;
        int res=0;
        par=new int[v];
        rank=new int[v];
        for(int i=0;i<v-1;i++)
        {
            for(int j=i+1;j<v;j++)
            {
                adj.add(new node(i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        Collections.sort(adj,(a,b)->(a.w-b.w));
                        for(int i=0;i<v;i++)
                        {
                            par[i]=i;
                            rank[i]=1;
                        }
        for(node j:adj)
                        {
                            if(find(j.u)!=find(j.v))
                            {
                                res+=j.w;
                                union(j.u,j.v);
                            }
                        }
                        return res;
        
        
    }
}