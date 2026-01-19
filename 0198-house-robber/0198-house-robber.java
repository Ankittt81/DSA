class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=Math.max((i+2<n?dp[i+2]:0)+nums[i],(i+1<n?dp[i+1]:0));
        }
        return dp[0];
    }
}