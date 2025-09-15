class Solution {
    public int maxFreqSum(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int maxvowel=0;
        int maxconst=0;
        for(int i=0;i<26;i++){
            // if(freq[i]==0) continue;
            char c=(char)(i+'a');
            if(isvowel(c)){
                maxvowel=Math.max(maxvowel,freq[i]);
            }
            else{
                maxconst=Math.max(maxconst,freq[i]);
            }
        }
        return maxvowel+maxconst;
    }
    boolean isvowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
}