// Import your library
// Do not change the name of the Solution class
public class Solution {
    /**
     * find n-th fibonacci number.
     * 0-based indexing, the 1st fibonacci number is 0.
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 1) {
            return n;
        }
        long a = 0;
        long b = 1;
        for (long i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - b < a) {
                return Long.MAX_VALUE;
            }
            long tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
} 