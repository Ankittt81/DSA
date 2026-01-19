class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int res=mincoin(amount,coins,dp);
        return (res==Integer.MAX_VALUE?-1:res);
    }
    int mincoin(int amount,int[] coins,int[] dp){
        if(amount==0) return dp[amount]=0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res=mincoin(amount-coins[i],coins,dp);
            if(res!=Integer.MAX_VALUE){
                 ans=Math.min(ans,res+1);
            }
           
        }
        return dp[amount]=ans;
    }
}