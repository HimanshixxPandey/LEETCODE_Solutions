class Solution {
    public int pivotInteger(int n) {
        
        if(n==1)
            return 1;
        int arr[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=i;
        }

        int s=0;
        for(int i=0;i<=n;i++)
        {
            s+=arr[i];
        }
        int s1=0;
        for(int i=0;i<=n;i++)
        {
             s1+=arr[i];
            if(s1==s)
            {
                return i;
            }
             s-=arr[i];
        }
        return -1;
        
    }
}