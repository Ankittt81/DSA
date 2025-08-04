class pair{
    int v;
    long t;
    pair(int v,long t){
        this.v=v;
        this.t=t;
    }
}

class Solution {
    int MOD=1000000007;
    public int countPaths(int n, int[][] roads) {
        ArrayList<int[]>[] graph=new ArrayList[n];
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        int[] ways=new int[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int t=roads[i][2];
            graph[u].add(new int[]{v,t});
            graph[v].add(new int[]{u,t});
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.t,b.t));
        pq.add(new pair(0,0));
        dist[0]=0;
        ways[0]=1;
        while(!pq.isEmpty()){
            pair rem=pq.poll();
            int v=rem.v;
            long t=rem.t;
            if(t>dist[v]) continue;
            for(int[] nbr:graph[v]){
                int nbrtime=nbr[1];
                int nbrver=nbr[0];
                if(t+nbrtime<dist[nbrver]){
                    dist[nbrver]=t+nbrtime;
                    ways[nbrver]=ways[v];
                    pq.add(new pair(nbrver,nbrtime+t));
                }
                else if(t+nbrtime==dist[nbrver]){
                    ways[nbrver]=(ways[v]+ways[nbrver])%MOD;
                }
                
            }
        }
        return ways[n-1];
    }
}