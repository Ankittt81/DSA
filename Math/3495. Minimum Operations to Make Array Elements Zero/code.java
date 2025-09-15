class Solution {
    public long minOperations(int[][] queries) {
        int n=queries.length;
        long totalsteps=0;
        for(int i=0;i<n;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            totalsteps+=((getoperation(r)-getoperation(l-1))+1)/2;
        }
        return totalsteps;
    }
    long getoperation(int num){
        if(num<=0) return 0;
        long steps=0;
        long res=0;
        for(int log4=1;log4<=num;log4*=4){
            steps++;
            int range=Math.min(num,log4*4-1);
            int count=range-log4+1;
            res+=count*steps;
        }
        return res;
    }
}