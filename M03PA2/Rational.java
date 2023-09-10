import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational> {
    
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    public Rational() {
        
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    private static BigInteger gcd(BigInteger numerator, BigInteger denominator) {
        
        numerator = numerator.abs();
        denominator = denominator.abs();
        return numerator.gcd(denominator);
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public Rational add(Rational secondRational) {
        
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));

        BigInteger d = denominator.multiply(secondRational.getDenominator());
        
        return new Rational(n, d);
    }

    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));

        BigInteger d = denominator.multiply(secondRational.getDenominator());

        return new Rational(n, d);
    }

    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());

        BigInteger d = denominator.multiply(secondRational.getDenominator());

        return new Rational(n, d);
    }

    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());

        BigInteger d = denominator.multiply(secondRational.getNumerator());

        return new Rational(n, d);
    }

    @Override
    public String toString() {
        
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString();
        else
            return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object other) {
        
        if (other instanceof Rational) {
            
            Rational rational = (Rational) other;
            return this.subtract(rational).getNumerator().equals(BigInteger.ZERO);
        }
        return false;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public int compareTo(Rational o) {
        BigInteger diff = this.subtract(o).getNumerator();
        return diff.compareTo(BigInteger.ZERO);
    }

//IMPORTANT: Click either space button or enter button to enter the denominators after entering the numerators

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first rational number: ");
        BigInteger numerator1 = scanner.nextBigInteger();
        BigInteger denominator1 = scanner.nextBigInteger();

        System.out.print("Enter the second rational number: ");
        BigInteger numerator2 = scanner.nextBigInteger();
        BigInteger denominator2 = scanner.nextBigInteger();

        Rational rational1 = new Rational(numerator1, denominator1);
        
        Rational rational2 = new Rational(numerator2, denominator2);

        System.out.println(rational1 + " + " + rational2 + " = " + rational1.add(rational2));
        
        System.out.println(rational1 + " - " + rational2 + " = " + rational1.subtract(rational2));
        
        System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2));
        
        System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2));
        
        System.out.println(rational2 + " is " + rational2.doubleValue());
    }
}
