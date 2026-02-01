class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
       List<Character>list=new ArrayList<>(map.keySet());
       list.sort((a,b)->map.get(b)-map.get(a));

       StringBuilder sb=new StringBuilder();
       for(char c:list){
        for(int i=0;i<map.get(c);i++){
            sb.append(c);
        }
       }
       return sb.toString();
    }
}