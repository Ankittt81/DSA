class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        Arrays.fill(leftmax,1);
        Arrays.fill(rightmax,1);
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]) leftmax[i]=leftmax[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) rightmax[i]=rightmax[i+1]+1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.max(leftmax[i],rightmax[i]);
        }
        return ans;
    }
}