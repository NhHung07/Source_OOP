package Week2.SoNguyenTo;

public class Solution {
    /**
     *  nếu nhỏ hơn 2 thì không là số nguyên tố.
     *  nếu lớn hơn 2 thì chia cho số từ 2 đến căn num để kiểm tra.
     */
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
