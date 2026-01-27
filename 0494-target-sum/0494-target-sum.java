class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        int n=nums.length;
        for(int val:nums){
            totalSum+=val;
        }
        int req=(totalSum+target)/2;
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0)
    return 0;

        int[][] dp=new int[n+1][req+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=req;j++){
                if(nums[i-1]==0) dp[i][j]=2*dp[i-1][j];
                else {
                    dp[i][j]=dp[i-1][j];
                    if(nums[i-1]<=j) dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][req];
    }
}