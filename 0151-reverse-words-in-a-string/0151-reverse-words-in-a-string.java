class Solution {
    public String reverseWords(String s) {
        String temp="";
        String ans="";
        int i=0;
        int j=s.length()-1;
        while(i<=j && s.charAt(i)==' ') i++;
        while(j>=i && s.charAt(j)==' ') j--;
        while(i<=j){
            char ch=s.charAt(i);
            if(ch==' '){
                if(!temp.isEmpty()){
                if(!ans.isEmpty()){
                    ans=temp+" "+ans;    
                }
                else ans=temp;
                temp="";
                
                
            }
            }
            else temp+=ch;
            i++;
        }
        if(!ans.isEmpty()) ans=temp+" "+ans;
        else ans=temp;
        return ans;
    }
}