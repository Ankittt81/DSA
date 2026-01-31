class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='M') num+=1000;
            else if(c=='D') num+=500;
            else if(c=='C'){
                if(i+1<n){
                    if(s.charAt(i+1)=='D'){
                        num+=400;
                        i++;
                    }else if(s.charAt(i+1)=='M'){
                        num+=900;
                        i++;
                    }else num+=100;
                }else num+=100;
            }
            else if(c=='L') num+=50;
            else if(c=='X'){
                if(i+1<n){
                    if(s.charAt(i+1)=='L'){
                        num+=40;
                        i++;
                    }else if(s.charAt(i+1)=='C'){
                        num+=90;
                        i++;
                    }else num+=10;
                }else num+=10;
            }
            else if(c=='V') num+=5;
            else{
                if(i+1<n){
                    if(s.charAt(i+1)=='V'){
                        num+=4;
                        i++;
                    }else if(s.charAt(i+1)=='X'){
                        num+=9;
                        i++;
                    }else num+=1;
                }else num+=1;
            }
        }
        return num;
    }
}