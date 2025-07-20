// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] vis=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                count++;
            }
        }
        return count;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] vis){
        vis[src]=true;
        for(int i=0;i<adj.size();i++){
            if(vis[i]==false && adj.get(src).get(i)==1) dfs(adj,i,vis);
        }
    }
};