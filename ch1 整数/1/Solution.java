class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int minus = 2;
        if (a >= 0) {
            a = -a;
            minus--;
        }
        if (b >= 0) {
            b = -b;
            minus--;
        }
        int res = helper(a, b);
        return minus == 1 ? -res : res;
    }

    private int helper(int dividend, int divisor) {
        int res = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= Integer.MIN_VALUE >> 1 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            res = res + quotient;
            dividend -= value;
        }
        return res;
    }
}
