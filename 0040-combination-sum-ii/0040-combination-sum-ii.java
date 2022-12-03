class Solution {
     public void combination(int ind,int target,int[]arr,ArrayList<Integer>ans,List<List<Integer>>temp){
     if(target==0)
    {
        temp.add(new ArrayList<>(ans));
        return;
    }
    for(int i=ind;i<arr.length;i++)
    {
        if(i>ind && arr[i]==arr[i-1])
        {
            continue;
        }
        if(arr[i]>target)
        {
            break;
        }
        ans.add(arr[i]);
        combination(i+1,target-arr[i],arr,ans,temp);
        ans.remove(ans.size()-1);
    }
     }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>temp=new ArrayList<>();
        Arrays.sort(candidates);
        combination(0,target,candidates,new ArrayList<>(),temp);
        return temp;
        
    }
}