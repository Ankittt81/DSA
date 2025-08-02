class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        ArrayList<Integer>[] reversegraph=new ArrayList[graph.length];
        int[] outdegree=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            reversegraph[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            outdegree[i]=graph[i].length;
            for(int nbr:graph[i]){
                reversegraph[nbr].add(i);
            }
        }
        for(int i=0;i<outdegree.length;i++){
            if(outdegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int rem=q.poll();
            ans.add(rem);
            for(int nbr:reversegraph[rem]){
                outdegree[nbr]--;
                if(outdegree[nbr]==0) q.add(nbr);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}