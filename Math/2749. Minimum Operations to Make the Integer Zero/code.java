class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=0;i<=60;i++){
            long val=(long)num1-i*(long)num2;
            if(val<0) continue;
            int bit=Long.bitCount(val);
            if(bit<=i && val>=i) return i; 
        }
        return -1;
    }
}