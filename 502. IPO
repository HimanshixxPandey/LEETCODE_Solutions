class Solution {
  
  class Pair{
    int first;  //profit
    int second; //capital
    Pair(int a, int b){
      first=a;
      second=b;
    }
  }
  
  static int cmp(Pair a, Pair b) {
    if (a.second != b.second) {
        return Integer.compare(a.second, b.second);
    } else {
        return Integer.compare(a.first, b.first);
    }
}
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Pair> list=new ArrayList<>();
        int n = profits.length;
        for(int i=0;i<n;i++)
          list.add(new Pair(profits[i],capital[i]));
        
        Collections.sort(list, Solution::cmp); 
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        while(k-->0){
          while(i<n && list.get(i).second <= w){
            pq.add(list.get(i).first);
            i++;
          }
          
          if(!pq.isEmpty()){
            w+=pq.poll();
          }
        }
        return w;
    }
}
