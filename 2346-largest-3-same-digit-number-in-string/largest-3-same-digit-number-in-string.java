class Solution {
    public String largestGoodInteger(String num) {
        char largest = 0; // store digit as char
        for (int i = 0; i <= num.length() - 3; ++i) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (num.charAt(i) > largest) {
                    largest = num.charAt(i);
                }
            }
        }
        if (largest == 0) return ""; // no good integer found
        return "" + largest + largest + largest; // build string
    }
}
