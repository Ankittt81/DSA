
class pair{
    int dist;
    int i;
    int j;
    pair(int dist,int i,int j){
        this.dist=dist;
        this.i=i;
        this.j=j;
    }
}

class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int[] dx={0,-1,0,1};
        int[] dy={1,0,-1,0};
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) {
                    q.add(new pair(0,i,j));
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            pair rem=q.poll();
            int val=rem.dist;
            int i=rem.i;
            int j=rem.j;
            grid[i][j]=val;
            for(int d=0;d<4;d++){
                int r=i+dx[d];
                int c=j+dy[d];
                if(r>=0 && r<n && c>=0 && c<m && vis[r][c]==false){
                    q.add(new pair(val+1,r,c));
                    vis[r][c]=true;
                }
            }
        }
        return grid;
    }
}