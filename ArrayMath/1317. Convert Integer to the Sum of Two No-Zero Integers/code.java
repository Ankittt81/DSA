class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans=new int[2];
        int x=1;
        int y=n-1;
        while(true){
            if(haszero(x) || haszero(y)){
                x++;
                y--;
                continue;
            }
            ans[0]=x;
            ans[1]=y;
            break;
        }
        return ans;
    }
    boolean haszero(int n){
        int rem=0;
        while(n>0){
            rem=n%10;
            if(rem==0) return true;
            n=n/10;
        }
        return false;
    }
}