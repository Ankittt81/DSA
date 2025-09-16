class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m=languages.length;
        List<Set<Integer>> langMap=new ArrayList<>();
        for(int i=0;i<m;i++){
            Set<Integer> set=new HashSet<>();
            for(int lang:languages[i]){
                set.add(lang);
            }
            langMap.add(set);
        }
        Set<Integer> candidates=new HashSet<>();
        for(int[] f:friendships){
            int u=f[0]-1;
            int v=f[1]-1;
            if(!cancommunicate(langMap.get(u),langMap.get(v))){
                candidates.add(u);
                candidates.add(v);
            } 
        } 
        if(candidates.isEmpty()) return 0;

        int minteach=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int teachcount=0;
            for(int user:candidates){
                if(!langMap.get(user).contains(i)) teachcount++;
            }
            minteach=Math.min(minteach,teachcount);
        }
        return minteach;
    }
    boolean cancommunicate(Set<Integer> s1,Set<Integer> s2){
        for(int lang:s1){
            if(s2.contains(lang)) return true;
        }
        return false;
    }
}