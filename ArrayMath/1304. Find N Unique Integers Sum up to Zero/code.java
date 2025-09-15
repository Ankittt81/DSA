class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        int index=0;
        int i=1;
        if(n%2!=0) ans[index++]=0;
        while(index<n){
            ans[index++]=i;
            if(index<n) ans[index++]=-i;
            i++;
        }
        return ans;
    }
}