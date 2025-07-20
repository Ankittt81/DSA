class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
       ArrayList<Integer>[] graph=new ArrayList[V];
       for(int i=0;i<V;i++){
           graph[i]=new ArrayList<>();
       }
       for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           graph[u].add(v);
       }
        boolean[] vis=new boolean[V];
        boolean[] path=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(dfs(graph,i,vis,path)==true) return true;
            }
        }
        return false;
    }
    boolean dfs( ArrayList<Integer>[] graph,int src, boolean[] vis,boolean[] path){
        vis[src]=true;
        path[src]=true;
        for(int nbr:graph[src]){
            if(path[nbr]==true) return true;
            if(vis[nbr]==false){
                if(dfs(graph,nbr,vis,path)==true) return true;
            }
        }
        path[src]=false;
        return false;
    }
}