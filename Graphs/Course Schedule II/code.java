class Solution {
    boolean hasCycle=false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       Stack<Integer> st=new Stack<>();
        int n=numCourses;
        int[] ans=new int[n];
        int k=0;
        boolean[] vis=new boolean[n];
        boolean[] path=new boolean[n];
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            graph[u].add(v);
        }
        for(int i=0;i<n;i++){
           if(vis[i]==false) dfs(graph,i,vis,path,st);
        }
        if(hasCycle) return new int[0];
       while(st.size()>0){
        ans[k++]=st.pop();
       }
       if(k==n) return ans;
       return new int[0];
    }
    void dfs( ArrayList<Integer>[] graph,int src,boolean[] vis,boolean[] path, Stack<Integer> st){
        vis[src]=true;
        path[src]=true;
        for(int nbr:graph[src]){
            if(path[nbr]==true){
                hasCycle=true;
                return;
            }
            if(vis[nbr]==false) dfs(graph,nbr,vis,path,st);
        }
        st.push(src);
        path[src]=false;
    }
}