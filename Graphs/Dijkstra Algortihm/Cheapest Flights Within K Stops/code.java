class pair{
    int v;
    int wt;
    int stop;
    pair(int v,int wt,int stop){
        this.v=v;
        this.wt=wt;
        this.stop=stop;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<pair>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        int[][] dist=new int[n][k+2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int price=flights[i][2];
            graph[u].add(new pair(v,price,0));
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new pair(src,0,0));
        dist[src][0]=0;
        while(pq.size()>0){
            pair rem=pq.poll();
            int v=rem.v;
            int wt=rem.wt;
            int stop=rem.stop;
            if(wt>dist[v][stop]) continue;
            if(v==dst) return wt;
            if(stop>k) continue;
            for(pair nbr:graph[v]){
                int vertex=nbr.v;
                int cost=nbr.wt;
                int newcost=cost+wt;
                int newstop=stop+1;
                if(newstop<=k+1 && newcost<dist[vertex][newstop]){
                    dist[vertex][newstop]=newcost;
                    pq.add(new pair(vertex,newcost,newstop));
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minCost = Math.min(minCost, dist[dst][i]);
        }
        
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}