class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int val:nums){
            sum+=val;
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        int[][] dp=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(j==0) dp[i][j]=1;
                else if(i==0) dp[i][j]=0;
                else{
                    int npick=dp[i-1][j];
                    int pick=0;
                    if(nums[i-1]<=j){
                        pick=dp[i-1][j-nums[i-1]];
                    }
                    if(pick==1 || npick==1) dp[i][j]=1;
                    
                }
            }
        }
        if(dp[n][target]==1) return true;
        return false;
    }
}