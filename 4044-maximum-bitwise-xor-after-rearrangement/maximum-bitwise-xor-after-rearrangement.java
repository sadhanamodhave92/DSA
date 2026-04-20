class Solution {
    public String maximumXor(String s, String t) {
        int ones=0;
        for(char c:t.toCharArray())
            if(c=='1') ones++;
        int zeros=t.length() - ones;
        StringBuilder ans = new StringBuilder();
        for(char c :s.toCharArray()){
            if(c=='0' && ones-- >0){
                ans.append('1');
            }else if(c=='1' && zeros-- >0){
                ans.append('1');
            } else{
                ans.append('0');
            }
        }
        return ans.toString();
        
    }
}