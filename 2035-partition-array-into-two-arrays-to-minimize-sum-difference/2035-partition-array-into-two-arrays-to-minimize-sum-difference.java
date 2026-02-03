class Solution {
    public int minimumDifference(int[] nums) {
        int n=nums.length/2;
        int totalSum=0;
        for(int num:nums) totalSum+=num;
        int[] left=Arrays.copyOfRange(nums,0,n);
        int[] right=Arrays.copyOfRange(nums,n,2*n);

        List<Integer>[] leftSum=new ArrayList[n+1];
        List<Integer>[] rightSum=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            leftSum[i]=new ArrayList<>();
            rightSum[i]=new ArrayList<>();
        }
        
        generate(left,0,0,0,leftSum);
        generate(right,0,0,0,rightSum);

        for(int i=0;i<=n;i++){
            Collections.sort(rightSum[i]);
        }

        int ans=Integer.MAX_VALUE;

        for(int k=0;k<=n;k++){
            List<Integer>L=leftSum[k];
            List<Integer>R=rightSum[n-k];

            for(int sumL:L){
                int target=totalSum/2-sumL;
                int idx=Collections.binarySearch(R,target);

                if(idx<0) idx=-idx-1;

                if(idx<R.size()) {
                    int sum=sumL+R.get(idx);
                    ans=Math.min(ans,Math.abs(totalSum - 2 * sum));
                }
                if(idx>0) {
                    int sum=sumL+R.get(idx - 1);
                    ans=Math.min(ans,Math.abs(totalSum - 2 * sum));
                }
            }
        }  
         return ans;
    }

    void generate(int[] arr,int idx,int count,int sum,List<Integer>[] res){
        if(idx==arr.length){
            res[count].add(sum);
            return;
        }

        generate(arr,idx+1,count+1,sum+arr[idx],res);
        generate(arr,idx+1,count,sum,res);
    }
}