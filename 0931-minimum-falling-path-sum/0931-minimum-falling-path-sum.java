class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        // int ans=Integer.MAX_VALUE;
        // for(int j=0;j<n;j++){
        //     ans=Math.min(ans,minSum(matrix,dp,n-1,j));
        // }
        // return ans;
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];

        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int minAbove=dp[i-1][j];

                if(j-1>=0) minAbove=Math.min(minAbove,dp[i-1][j-1]);
                if(j+1<n) minAbove=Math.min(minAbove,dp[i-1][j+1]);

                dp[i][j]=minAbove+matrix[i][j];
            }
        }

        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[n-1][j]);
        }

        return ans;
    }

//    int minSum(int[][] matrix,int[][] dp,int i,int j){
//     if(j<0 || j>=matrix.length) return Integer.MAX_VALUE;
//         if(i==0 ){
//             return dp[0][j]=matrix[0][j];
//         }
        
       
//         if(dp[i][j]!=-1) return dp[i][j];
//         int minAbove=minSum(matrix,dp,i-1,j);
//         int minAboveLeft=Integer.MAX_VALUE;
//         int minAboveRight=Integer.MAX_VALUE;
//        if(j-1>=0) minAboveLeft=minSum(matrix,dp,i-1,j-1);
//        if(j+1<matrix.length) minAboveRight=minSum(matrix,dp,i-1,j+1);
//         int ans=Math.min(minAbove,Math.min(minAboveLeft,minAboveRight));
//         ans=ans+matrix[i][j];
//         return dp[i][j]=ans;
//     }
}