class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        int[] indegree=new int[numCourses];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList();
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            graph[u].add(v);
        }
        for(int i=0;i<indegree.length;i++){
            for(int nbr:graph[i]){
                indegree[nbr]++;
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()>0){
            int rem=q.poll();
            
            for(int nbr:graph[rem]){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]!=0) return false;
        }
        return true;
    }
}