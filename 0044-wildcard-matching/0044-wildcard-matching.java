class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=1;
        for(int j=1;j<=m;j++){
            if(p.charAt(j-1)=='*') dp[0][j]=1;
            else break;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j==0) dp[i][j]=0;
                else{
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') dp[i][j]=dp[i-1][j-1];
                    else if(p.charAt(j-1)=='*'){
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                    else dp[i][j]=0;
                }
            }
        }
        if(dp[n][m]==1) return true;
        return false;
    }
}