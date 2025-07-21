class Solution {
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        Set<String> word=new HashSet<>(Arrays.asList(wordList));
        if(!word.contains(targetWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(startWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                for(int j=0;j<curr.length();j++){
                    char[] chars=curr.toCharArray();
                    for(char c='a';c<='z';c++){
                        chars[j]=c;
                        String newString=new String(chars);
                        if(newString.equals(targetWord)) return level+1;
                        if(word.contains(newString)){
                            q.add(newString);
                            word.remove(newString);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}