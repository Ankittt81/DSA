class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int zero=0;
        int one=0;
        int two=arr.length-1;
        while(one<=two){
            if(arr[one]==0){
                swap(arr,one,zero);
                one++;
                zero++;
            }
            else if(arr[one]==2){
                swap(arr,one,two);
                two--;
            }
            else one++;
        }
        
    }
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}