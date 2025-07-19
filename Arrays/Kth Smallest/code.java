// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:arr){
            pq.add(num);
        }
        int ans=-1;
        while(k-->0){
            ans=pq.poll();
        }
        return ans;
    }
}
