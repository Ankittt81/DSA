class Solution {
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        ArrayList<Integer>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(dfs(graph,i,-1,vis)==true) return true;
            }
        }
        return false;
    }
    boolean dfs( ArrayList<Integer>[] graph,int src,int parent,boolean[] vis){
        vis[src]=true;
       
        for(int nbr:graph[src]){
           if(vis[nbr]==false){
               if(dfs(graph,nbr,src,vis)==true) return true;
           }
           else if(nbr!=parent) return true;
        }
        return false;
    }
}