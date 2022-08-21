class Solution {
    public int minimumRecolors(String b, int k) {
     int p=b.length()-k,x=Integer.MAX_VALUE;
        for(int i=0;i<=p;i++)
        {
            String f=b.substring(i,i+k);
            int m=0;
            for(char c:f.toCharArray())
            {
                if(c=='W')
                   m++; 
            }
            x=Math.min(x,m);
        }
        return x;
    }
}