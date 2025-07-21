class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int[] dx={0,-1,0,1};
        int[] dy={1,0,-1,0};
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(grid[i][0]==1) q.add(new pair(i,0));
            if(grid[i][m-1]==1) q.add(new pair(i,m-1));
        }
         for(int i=0;i<m;i++){
            if(grid[0][i]==1) q.add(new pair(0,i));
            if(grid[n-1][i]==1) q.add(new pair(n-1,i));
        }
        while(!q.isEmpty()){
            pair rem=q.poll();
            int x=rem.x;
            int y=rem.y;
            grid[x][y]=-1;
            for(int d=0;d<4;d++){
                int r=x+dx[d];
                int c=y+dy[d];
                if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==1){
                    q.add(new pair(r,c));
                    grid[r][c]=-1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
}