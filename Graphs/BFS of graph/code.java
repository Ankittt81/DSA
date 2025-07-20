class Solution {
    // Function to return Breadth First Search Traversal of given graph.
     ArrayList<Integer>ans=new ArrayList<>();
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
       
        int n=adj.size();
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                bfs(adj,i,vis);
            }
        }
        return ans;
    }
    void bfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] vis){
        vis[src]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int rem=q.poll();
            ans.add(rem);
            ArrayList<Integer> al=adj.get(rem);
            for(int nbr:al){
                if(vis[nbr]==false){
                    vis[nbr]=true;
                    q.add(nbr);
                }
            }
        }
    }
}