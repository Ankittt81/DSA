class pair{
    int x;
    int y;
    int val;
    pair(int x,int y,int val){
        this.x=x;
        this.y=y;
        this.val=val;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[] dx={0,-1,0,1};
        int[] dy={1,0,-1,0};
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0) {
                    q.add(new pair(i,j,mat[i][j]));
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            pair rem=q.poll();
            int x=rem.x;
            int y=rem.y;
           int val=rem.val;
           mat[x][y]=val;
            for(int d=0;d<4;d++){
                int r=x+dx[d];
                int c=y+dy[d];
                if(r>=0 && r<n && c>=0 && c<m && vis[r][c]==false){
                    q.add(new pair(r,c,val+1));
                    vis[r][c]=true;
                } 
            }
        }
        return mat;
    }
}