class Pair{
    int time;
    int i;
    int j;
    Pair(int time,int i,int j){
        this.time=time;
        this.i=i;
        this.j=j;
    }
}

class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        int[] dx={0,-1,0,1};
        int[] dy={1,0,-1,0};
        int ans=0;
        int count=0;
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2) q.add(new Pair(0,i,j));
                else if(mat[i][j]==1) count++;
            }
        }
        while(!q.isEmpty()){
            Pair rem=q.poll();
            int t=rem.time;
            int x=rem.i;
            int y=rem.j;
            ans=t;
            for(int d=0;d<4;d++){
                int r=x+dx[d];
                int c=y+dy[d];
                if(r>=0 && r<n && c>=0 && c<m && mat[r][c]==1){
                    mat[r][c]=2;
                    count--;
                    q.add(new Pair(t+1,r,c));
                }
            }
        }
       if(count!=0) return -1;
       return ans;
    }
}