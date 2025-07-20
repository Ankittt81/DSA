class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] dx={0,-1,0,1};
        int[] dy={1,0,-1,0};
        // Code here
        if(image[sr][sc]==newColor) return image;
        int n=image.length;
        int m=image[0].length;
        Queue<pair> q=new LinkedList<>();
        int p=image[sr][sc];
        image[sr][sc]=newColor;
        q.add(new pair(sr,sc));
        while(!q.isEmpty()){
            pair rem=q.poll();
            int x=rem.x;
            int y=rem.y;
            for(int d=0;d<4;d++){
                int r=x+dx[d];
                int c=y+dy[d];
                if(r>=0 && r<n && c>=0 && c<m && image[r][c]==p){
                    image[r][c]=newColor;
                    q.add(new pair(r,c));
                }
            }
        }
        return image;
    }
}