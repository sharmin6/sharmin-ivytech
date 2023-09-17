import java.io.*;
import java.util.*;

public class MatchGroupSymbols {

    public static void main(String[] args) {
//Line 7-22: Asking the user to enter a Java source code to check wheather that source code the user have enter has matching grouping symbols.
//NOTE: I have a sample code (SampleCode.java) for you to use to see if the program works or not. It should say "Your source code has matching grouping symbols." When you type "SampleCode.java".
            
            Scanner scanner = new Scanner(System.in);

            //Asking the user to enter a java source code.    
            System.out.print("Enter a Java source code to check matching grouping symbols: ");
            //storing user's entered source code into 'fileName' variable.
            String fileName = scanner.nextLine();
//If the source code has matching grouping symbols then it will display the message on line 18.     
            if (validationFile(fileName)) {
                System.out.println("Your source code has matching grouping symbols.");
            } 

//Else, if the does not have matching grouping symbols then it will display the message on line 23.           
            else {
                System.out.println("Your source code doesn not have macthing grouping symbols.");
            }
            
            //close scanner when it's done.
            scanner.close();
        }

//This method performs the actual validation of grouping symbols in the specified Java source code file.
    public static boolean validationFile(String fileName) {

//The method uses a try-catch block to handle any potential file input/output exceptions that might occur during file reading.        
        try {
//Initializes a BufferedReader to read the contents of the specified file.            
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//Creates a stack of characters to keep track of opening symbols as they are encountered in the source code.            
            Stack<Character> stack = new Stack<>();

            String line; //Reads the file line by line.
            
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) { //Outer for-loop will iterates over each character in the current line of the source code.
//Checks if the current character is an opening symbol "(, {, or ["" and pushes it onto the stack if it is.                    
                    if (isOpenSymbol(ch)) {
                        stack.push(ch);
                    } 
//Checks if the current character is a closing symbol "), }, or ])" and compares it to the top of the stack to see if it forms a matching pair.                    
                    else if (isCloseSymbol(ch)) {
//If not, or if the stack is empty, it returns false.                        
                        if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                            return false;
                        }
                    }
                }
            }

//it returns true to indicate correct grouping symbols in the Java source code.
            return stack.isEmpty();
        }

//IOException occurs during file reading, it prints an error message on line 64.        
        catch (IOException e) {
            System.err.println("Can not read the file " + e.getMessage());
            return false; //returns false to indicate that the validation process encountered an error.
        }
    }

//This method checks if ch is an opening grouping symbol "(, {, [""
    private static boolean isOpenSymbol(char ch) {
        ////returns true if ch is one of the specified opening symbols and false otherwise.
        return ch == '(' || ch == '{' || ch == '['; 
    }

//This method checks if ch is a closing grouping symbol "), }, ]".
    private static boolean isCloseSymbol(char ch) {
        //returns true if ch is one of the specified closing symbols/
        return ch == ')' || ch == '}' || ch == ']'; 
    }

//This method Determines if open and close form a matching pair of grouping symbols.
    private static boolean isMatchingPair(char open, char close) {
        //returns true if the pair forms a matching pair of grouping symbols.
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}