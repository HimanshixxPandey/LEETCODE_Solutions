class Solution {
    class pair{
        int row;
         int column;
        pair(int row,int column)
        {
            this.row=row;
            this.column=column;
        }
    }
    public int orangesRotting(int[][] grid) {
        int c=0;
        Queue<pair>q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new pair(i,j));
                }
                else if(grid[i][j]==1)
                {
                        c++;
                }
            }
        }
        int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
        int level=0;
        if(c==0)
        {
            return 0;
        }
        while(q.size()>0)
        {
            int s=q.size();
            level++;
            while(s-->0)
            {
                pair rem=q.remove();
                for(int i=0;i<dir.length;i++)
                {
                    int rowdash=rem.row+dir[i][1];
                    int coldash=rem.column+dir[i][0];
                    if(rowdash>=0 && coldash>=0&& rowdash<grid.length&& coldash<grid[0].length&&grid[rowdash][coldash]==1)
                    {
                        q.add(new pair(rowdash,coldash));
                        grid[rowdash][coldash]=0;
                        c--;
                    }
                }
                
                
            }
          
        }
        if(c==0)
        {
            return level-1;
        }
        else
        {
            return -1;
        }
        
    }
    
}