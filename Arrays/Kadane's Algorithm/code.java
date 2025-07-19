class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
           sum=sum+arr[i];
           if(sum>ans) ans=sum;
           if(sum<0) sum=0;
        }
      return ans;
    }
}
