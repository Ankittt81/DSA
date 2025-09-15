import java.util.HashSet;
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set=new HashSet(26);
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        String[] words=text.split(" ");
        int count=0;
        for(String word:words){
            boolean cantype=true;
            for(char c:word.toCharArray()){
               if(set.contains(c)){
                cantype=false;
                break;
               }
            }
            if(cantype) count++;
        }
        return count;
    }
}