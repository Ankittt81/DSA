class Solution {
    public int maxDepth(String s) {
        int braces=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') braces++;
            else if(c==')') braces--;
            max=Math.max(max,braces);
        }
        return max;
    }
}