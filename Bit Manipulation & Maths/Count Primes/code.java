class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1) return 0;
        int ans=0;
        boolean[] prime=new boolean[n];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i*i<n;i++){
            if(prime[i]==true){
                for(int j=i*i;j<n;j+=i){
                    prime[j]=false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(prime[i]==true) ans++;
        }
        return ans;
    }
}