class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        for( List<Integer>a:edges)
        {
            List<Integer>l=a;
            int k=a.get(0);
            int v=a.get(1);
            if(map.get(k)==null)
            {
                map.put(k, new ArrayList<Integer>());
            }
            map.get(k).add(v);
        }
        int arr[]=new int[n];
       
        System.out.println(map);
        for(ArrayList<Integer> s:map.values())
        {
            ArrayList<Integer>ans=s;
            for(int i=0;i<ans.size();i++)
            {
                arr[ans.get(i)]=1;
                
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                list.add(i);
            }
        }
        if(list.size()==0)
        {
            list.add(edges.get(0).get(0));
            return list;
        }
        return list;
        
    }
}