class Solution {
    int []par;
	int []rank;
	int count=0;
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
    public int Union(int x,int y)
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
        else{
            count++;
        }
        return count;
    }
    
	public int regionsBySlashes(String[] grid) {
		int n=grid.length;
		int dots=n+1;
		rank=new int[dots*dots];
		par=new int[dots*dots];
		for(int i=0;i<dots*dots;i++)
		{
			par[i]=i;
			rank[i]=1;
		}
		count=1;
		 for (int i = 0; i < dots; i += 1) {
			for (int j = 0; j < dots; j += 1) {
				if(i==0 || j==0 || i==n || j==n)
				{
					int cellNo=i*dots+j;
					if(cellNo!=0)
						Union(0,cellNo);
				}
			}
		 }
		  for (int i = 0; i < n; i += 1) {
			char[] ch = grid[i].toCharArray();
			for (int j = 0; j < ch.length; j += 1) {
				if (ch[j] == '/') {
					int startCellNumber = i * dots + (j + 1);
					int endCellNumber = (i + 1) * dots + j;
					Union(startCellNumber, endCellNumber);
				} else if (ch[j] == '\\') {
					int startCellNumber = i * dots + j;
					int endCellNumber = (i + 1) * dots + (j + 1);
					Union(startCellNumber, endCellNumber);
				}
			}
		}
		return count;

	}
        
}