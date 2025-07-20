class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> ans=new ArrayList<>();
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n=adj.size();
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfsalgo(adj,i,vis);
            }
        }
        return ans;
    }
    void dfsalgo(ArrayList<ArrayList<Integer>> adj,int src,boolean[] vis){
        vis[src]=true;
        ans.add(src);
        ArrayList<Integer> al=adj.get(src);
        for(int nbr:al){
            if(vis[nbr]==false){
                dfsalgo(adj,nbr,vis);
            }
        }
    }
}