class Solution {
    public String sortVowels(String s) {
        List<Character> vowels=new ArrayList<>();
        for(char c:s.toCharArray()) if(isVowel(c)) vowels.add(c);
        Collections.sort(vowels);
        int idx=0;
        StringBuilder result=new StringBuilder();
        for(char c:s.toCharArray()){
            if(isVowel(c)) result.append(vowels.get(idx++));
            else result.append(c);
        }
        return result.toString();
    }
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}