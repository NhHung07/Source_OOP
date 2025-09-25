package Week2.UocChungLonNhat;

public class Solution {
    /**
     *  Swap b và a%b cho đến khi b = 0 thì gcd chính là a.
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }
}
