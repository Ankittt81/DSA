class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n=g.length;
        int m=s.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                if(s[j]>=g[i]){
                   ans++; 
                   break;
                } 
            }
        }
        return ans;
    }
}