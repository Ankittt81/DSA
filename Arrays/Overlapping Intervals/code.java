class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]>ans=new ArrayList<>();
        int st=arr[0][0];
        int e=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(e>=arr[i][0]){
                st=Math.min(st,arr[i][0]);
                e=Math.max(e,arr[i][1]);
            }
            else{
                int[] curr=new int[2];
                curr[0]=st;
                curr[1]=e;
                ans.add(curr);
                st=arr[i][0];
                e=arr[i][1];
            }
        }
        int[] curr=new int[2];
        curr[0]=st;
        curr[1]=e;
        ans.add(curr);
        return ans;
    }
}