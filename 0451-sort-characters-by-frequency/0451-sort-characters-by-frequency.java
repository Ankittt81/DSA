class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>[] bucketList=new ArrayList[n+1];
        for(char c:map.keySet()){
            int freq=map.get(c);
            if(bucketList[freq]==null){
                bucketList[freq]=new ArrayList<>();
            }
            bucketList[freq].add(c);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=bucketList.length-1;i>=0;i--){
            if(bucketList[i]!=null){
                for(char c:bucketList[i]){
                    for(int k=1;k<=i;k++)
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}