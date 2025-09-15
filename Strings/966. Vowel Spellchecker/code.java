import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exact=new HashSet<>();
        HashMap<String,String> casemap=new HashMap<>();
        HashMap<String,String> vowel=new HashMap<>();
        for(String word:wordlist){
            exact.add(word);
            String lower=word.toLowerCase();
            casemap.putIfAbsent(lower,word);
            String devowel=devowel(lower);
            vowel.putIfAbsent(devowel,word);
        } 
        String[] ans=new String[queries.length];
        for(int i=0;i<queries.length;i++){
            String q=queries[i];
            if(exact.contains(q)) ans[i]=q;
            else{
                String lower=q.toLowerCase();
                if(casemap.containsKey(lower)) ans[i]=casemap.get(lower);
                else {
                    String devowel=devowel(lower);
                    ans[i]=vowel.getOrDefault(devowel,"");
                }
            }
        }
        return ans;
    }
    String devowel(String word){
        StringBuilder sb=new StringBuilder();
        for(char c:word.toCharArray()){
            if("aeiou".indexOf(c)>=0) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }
}