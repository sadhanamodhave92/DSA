class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) 
    {
        int n = colors.length, start = -1;
        
        if(colors[0] == colors[n-1]) {
            start = 0;
        } else {
            for(int i=1; i<n; i++) {
                if(colors[i] == colors[i-1]) {
                    start = i;
                    break;
                }
            }
        }

        if(start == -1) {
            return n;
        }
        int i = (start + 1) % n;
        int cont = 1, groups = 0;
        while(i != start) {
            if(colors[i] == colors[(i-1+n)%n]) {
                cont = 1;
            } else {
                cont++;
            } 
            if(cont >= k) groups++;
            i = (i + 1) % n;
        }
        return groups;
    }
}