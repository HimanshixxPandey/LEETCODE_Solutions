class Solution {
    public int gcd(int a,int b)
    {
        if(a==0)
        {
            return b;
        }
        return gcd(b%a,a);
    }
    public int lcm(int a,int b)
    {
        return ((a/gcd(a,b))*b);
    }
    public int subarrayLCM(int[] nums, int k) {
          int count = 0, lcm = 1;
           for(int i = 0; i < nums.length; i++) {
            lcm = 1;
            for(int j = i; j < nums.length; j++) {
                lcm = lcm(lcm, nums[j]);
                if(lcm == k) count++;
                else if(lcm > k) break;
            }
        }
        return count;
    }
}