//NOTE: This program will only check "is valid" only when you enter
//the number "4388576018410707". Any other number will display "is invalid".
//I am not sure wheather the assignment instruction want me to only
//say "is valid" ONLY when you enter the card number "4388576018410707"
//That number was given in the 6.31 assignment.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a credit card number as a long integer: ");
        long cardNum = scanner.nextLong();
        
        if (isValid(cardNum)) {
            System.out.println(cardNum + " is valid");
        } 
        
        else {
            System.out.println(cardNum + " is invalid");
        }
        
        scanner.close();
    }
    
    public static boolean isValid(long number) {
        int size = getSize(number);
        
        if (size < 13 || size > 16) {
            return false;
        }
        
        if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) {
            return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
        }
        
        return false;
    }
    
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            int doubled = digit * 2;
            sum += getDigit(doubled);
        }
        
        return sum;
    }
    
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number % 10 + number / 10;
        }
    }
    
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += digit;
        }
        
        return sum;
    }
    
    public static boolean prefixMatched(long number, int d) {
        int prefix = (int) getPrefix(number, getSize(d));
        return prefix == d;
    }
    
    public static int getSize(long d) {
        return Long.toString(d).length();
    }
    
    public static long getPrefix(long number, int k) {
        if (getSize(number) > k) {
            String numStr = Long.toString(number);
            return Long.parseLong(numStr.substring(0, k));
        }
        return number;
    }
}
