// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int first=-1;
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==x){
                first=mid;
                h=mid-1;
            }
            else if(arr[mid]>x) h=mid-1;
            else l=mid+1;
        }
        int last=-1;
        l=0;
        h=arr.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==x){
                last=mid;
                l=mid+1;
            }
            else if(arr[mid]>x) h=mid-1;
            else l=mid+1;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(first);
        ans.add(last);
        return ans;
    }
}
