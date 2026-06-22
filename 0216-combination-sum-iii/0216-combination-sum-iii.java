class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>temp = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        combinationSum(1,n,temp,ans,k);
        return ans;
    }
    private void combinationSum(int ind,int sum,List<Integer>temp,List<List<Integer>>ans,int k){
        if(sum == 0 && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
        }
        if (sum <= 0 || temp.size() > k) return;
        for(int i = ind; i<= 9; i++) {
            if(i <= sum){
                temp.add(i);
                combinationSum(i+1,sum-i,temp,ans,k);
                temp.remove(temp.size() - 1);
            } else{
                return ;
            }
        }
    }
}