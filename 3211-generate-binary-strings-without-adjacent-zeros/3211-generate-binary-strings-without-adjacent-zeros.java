class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(ans,0,sb,n);
        return ans;
        
    }
    
    public void helper(List<String>ans,int index,StringBuilder seq,int n){
        if(index == n){
             ans.add(seq.toString());
            return;
        }
        if((seq.length() > 0 && seq.charAt(seq.length() - 1) != '0') || seq.length() == 0){
            seq.append('0');
            helper(ans,index+1,seq,n);
            seq.deleteCharAt(seq.length()-1);

        }
        seq.append('1');
        helper(ans,index+1,seq,n);
        if(seq.length() > 0)
        seq.deleteCharAt(seq.length() - 1); 
    }
}