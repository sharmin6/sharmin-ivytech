import java.util.Scanner;

class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();
        
        if (validBinary(binaryString)) {
            int stringTodecimal = bin2Dec(binaryString);
            System.out.println("Decimal form: " + stringTodecimal);
        } 
        
        else {
            System.out.println("That is not a binary number you have entered");
        }

        scanner.close();
    }
    
        public static boolean validBinary(String binaryString) {
        for (char character : binaryString.toCharArray()) {
            if (character != '0' && character != '1') {
                return false;
            }
        }
        return true;
    }

    public static int bin2Dec(String binaryString) {
        int stringTodecimal = 0;
        int lengthOfBinary = binaryString.length();

        for (int i = 0; i < lengthOfBinary; i++) {
            int bit = Character.getNumericValue(binaryString.charAt(i));
            stringTodecimal += bit * Math.pow(2, lengthOfBinary - 1 - i);
        }

        return stringTodecimal;
    }

}
