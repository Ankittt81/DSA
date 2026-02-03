class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content=0;
        int i=0;
        int j=0;
        int n=g.length;
        int m=s.length;
        while(i<n && j<m){
            if(s[j]>=g[i]){
                content++;
                i++;
                j++;
            }
            else j++;
        }
        return content;
    }
}