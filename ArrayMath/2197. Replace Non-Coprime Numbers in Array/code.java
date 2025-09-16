class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack=new ArrayList<>();
        for(int num:nums){
            stack.add(num);

            while(stack.size()>=2){
                int b=stack.remove(stack.size()-1);
                int a=stack.remove(stack.size()-1);
                int g=gcd(a,b);
                if(g>1){
                    long lcm=a/g*b;
                    stack.add((int)lcm);
                }
                else{
                    stack.add(a);
                    stack.add(b);
                    break;
                }
            }
        }
        return stack;
    }
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}