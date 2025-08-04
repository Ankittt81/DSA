class pair{
    int x;
    int y;
    int wt;
    pair(int x,int y,int wt){
        this.x=x;
        this.y=y;
        this.wt=wt;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        int[][] dist=new int[heights.length][heights[0].length];
        for(int[]curr:dist){
            Arrays.fill(curr,Integer.MAX_VALUE);
        }
        pq.add(new pair(0,0,0));
        dist[0][0]=0;
        while(pq.size()>0){
            pair rem=pq.poll();
            int x=rem.x;
            int y=rem.y;
            int wt=rem.wt;
            if(x==heights.length-1 && y==heights[0].length-1) return wt;
            if(wt>dist[x][y]) continue;
            for(int d=0;d<4;d++){
                int dx=x+dir[d][0];
                int dy=y+dir[d][1];
                if(dx>=0 && dy>=0 && dx<heights.length && dy<heights[0].length){
                    int eff=Math.max(wt,Math.abs(heights[x][y]-heights[dx][dy]));
                    if(eff<dist[dx][dy]) {
                         dist[dx][dy]=eff;
                          pq.add(new pair(dx,dy,eff));
                    }
                   
                   
                }
            }
        }
        return 0;
    }
}