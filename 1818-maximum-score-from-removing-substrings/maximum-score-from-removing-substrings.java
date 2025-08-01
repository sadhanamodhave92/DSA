class Solution {
    // using stack
    public int maximumGain(String s, int x, int y) {
        // to decide which pair should be removed
        if(x < y){
            return remove(s, 'b', 'a', y, x);
        } else {
            return remove(s, 'a', 'b', x, y);
        }
        
    }
    private int remove(String s, char first, char second, int firstPt, int secondPt){
        int score =0;
        char[] arr=s.toCharArray();
        int n = arr.length;
        char[] stack= new char[n];
        int idx=0;
        for(char c: arr){
            if(idx > 0 && stack[idx-1] == first && c==second){
                idx--;
                score+=firstPt;
            } else {
                stack[idx++] =c;
            }
        }
        int idx2=0;
        char[] stack2= new char[n];
        for(int i=0;i<idx;i++){
            char c= stack[i];
            if(idx2>0 && stack2[idx2-1]== second && c==first){
                idx2--;
                score+=secondPt;
            } else {
                stack2[idx2++] = c;
            }
        }
        return score;
    }
}