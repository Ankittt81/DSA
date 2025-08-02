class pair{
    int x;
    int y;
    int length;
    pair(int x,int y,int length){
        this.x=x;
        this.y=y;
        this.length=length;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir={{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}};
        Queue<pair> q=new LinkedList<>();
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        if(n==1) return 1;
        pair p= new pair(0,0,1);
        q.add(p);
        grid[0][0]=1;
        while(!q.isEmpty()){
            pair rem=q.poll();
            int x=rem.x;
            int y=rem.y;
            int l=rem.length;
            if(x==n-1 && y==n-1) return l;
            for(int d=0;d<dir.length;d++){
                int dx=x+dir[d][0];
                int dy=y+dir[d][1];
                if(dx>=0 && dy>=0 && dx<n && dy<n && grid[dx][dy]==0){
                    q.add(new pair(dx,dy,l+1));
                    grid[dx][dy]=1;
                }
            }
        }
        return -1;
    }
}