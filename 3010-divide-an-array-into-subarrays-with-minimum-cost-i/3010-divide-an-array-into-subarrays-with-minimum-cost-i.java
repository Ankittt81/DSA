class Solution {
    public int minimumCost(int[] nums) {
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<first){
                second=first;
                first=nums[i];

            }else if(nums[i]<second){
                second=nums[i];
            }
        }
        return first+second+nums[0];
    }
}