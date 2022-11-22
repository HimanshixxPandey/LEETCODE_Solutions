class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int []e:edges)
        {
            int k=e[0];
            int v=e[1];
            if(map.get(k)==null)
            {
                map.put(k,new ArrayList<Integer>());
            }
            if(map.get(v)==null)
            {
                  map.put(v,new ArrayList<Integer>());
              }
            map.get(k).add(v);
            map.get(v).add(k);
            
        }
        System.out.println(map);
       for(int s:map.keySet())
       {
           ArrayList<Integer>list=map.get(s);
           if(list.size()==edges.length)
           {
               return s;
           }
       }
        return -1;
        
    }
}