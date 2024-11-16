package competetive;

class Solution {
    public int mySqrt(int x) {
        if(x == 1) { return 1; }
        int divisor = 2;
        int dividend, y;
        while((double)(x/divisor) * (x/divisor) > x) { divisor++; }
        return x/divisor;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}
