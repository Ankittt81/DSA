class pair{
    int v;
    int t;
    pair(int v,int t){
        this.v=v;
        this.t=t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] graph=new ArrayList[n+1];
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int t=times[i][2];
            graph[u].add(new int[]{v,t});
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.t-b.t);
        pq.add(new pair(k,0));
        dist[k]=0;
        while(pq.size()>0){
            pair rem=pq.poll();
            int v=rem.v;
            int t=rem.t;
            if(t>dist[v]) continue;
            for(int[] curr:graph[v]){
                int vertex=curr[0];
                int time=curr[1];
                if(dist[vertex]>time+t){
                    dist[vertex]=time+t;
                    pq.add(new pair(vertex,time+t));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}