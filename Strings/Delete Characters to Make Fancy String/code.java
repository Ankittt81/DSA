class Solution {
    public String makeFancyString(String s) {
        StringBuilder str=new StringBuilder();
        char c='\0';
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==c) count++;
            else count=1;
            if(count<3) str.append(ch);
            c=ch;
        }
        return str.toString();
    }
}