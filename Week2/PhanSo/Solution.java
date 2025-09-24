package Week2.PhanSo;

public class Solution {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Solution(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b,a % b);
    }

    public Solution reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        return this;
    }

    public Solution add(Solution other) {
        int newNumerator = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        this.numerator = newNumerator;
        this.denominator = newDenominator;
        return this.reduce();
    }

    public Solution subtract(Solution other) {
        int newNumerator = this.numerator * other.getDenominator() - other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        this.numerator = newNumerator;
        this.denominator = newDenominator;
        return this.reduce();
    }

    public Solution multiply(Solution other) {
        denominator *= other.getDenominator();
        numerator *= other.getNumerator();
        return this.reduce();
    }

    public Solution divide(Solution other) {
        if (other.getNumerator() == 0) {
            return this;
        }

        denominator *= other.getNumerator();
        numerator *= other.getDenominator();
        return this.reduce();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution)obj;
            this.reduce();
            other.reduce();
            if (numerator == 0  && other.numerator == 0) {
                return true;
            }
            return numerator == other.numerator && denominator == other.denominator;
        }
        return false;
    }
}
