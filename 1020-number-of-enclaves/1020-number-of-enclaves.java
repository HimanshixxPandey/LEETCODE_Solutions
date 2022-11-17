class Solution {
    public int numEnclaves(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0 || j==0||i==grid.length-1||j==grid[0].length-1)
                {
                    if(grid[i][j]==1)
                    {
                       count(grid,i,j);
                        
                    }
                }
            }
            
        }
         for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    c++;
                }
            }
         }
        return c;
        
        
    }
    public void count(int[][]grid,int i,int j)
    {
        if(i<0 || j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0)
        {
            return;
        }
        grid[i][j]=0;
        count(grid,i+1,j);
        count(grid,i-1,j);
        count(grid,i,j+1);
        count(grid,i,j-1);
    }
}