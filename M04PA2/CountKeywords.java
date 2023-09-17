//Using the Listing 21.7 from the textbook to test the code.
//Enter in 'SampleCode.java' to test the Listing 21.7.

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class CountKeywords {
    public static void main(String[] args) {

//Starts a try block and creates a Scanner object named input to read input from the standard input stream         
        try (Scanner input = new Scanner(System.in)) {
            //Asking the user to enter a file name.
            System.out.print("Enter a Java source file name (with '.java' extension): ");
            //Storing the user's file name inside 'filename' variable.
            String filename = input.nextLine();

//creatds a File object named file by using the filename provided by the user. This File object represents the file specified by the user.            
            File file = new File(filename);

//The if statement checks if the file specified by the user exists in the file system.
            if (file.exists()) {
//If the file exists, this line prints a message to the console indicating that the program will count the keywords in the specified file.                
                System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
            } 

//The else statement will be executed If the file name entered by the user does not exist            
            else {
                System.out.println("The entered file " + filename + " does not exist");
            }
        } 

//The catch block is used to handle any exceptions of type Exception or its subclasses that might occur within the corresponding try block        
        catch (Exception e) {
//The method is a built-in method prints a detailed trace of the exception, including the line numbers and method calls that led to the exception.            
            e.printStackTrace();
        }
    }

//countKeywords method is to receive a File object as input, representing a Java source code file. 
    public static int countKeywords(File file) {
//Initialize an array called keywordString with a list of Java keywords.        
        String[] keywordString = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient",
            "try", "void", "volatile", "while", "true", "false", "null"
        };

//Set is being used as a constructor to initialize keywordSet. The constructor takes a collection List created from an array and converts it into a HashSet
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString)); //Arrays.asList converts the 'keywordString' array, which contains Java keywords into a List of strings.
                                    //Then it will creates a HashSet from this List, to make sure that duplicates are removed.
        int count = 0; //Count variable will be used to keep track of the count of Java keywords found in the code.
//This variable is used to keep track of to see if the code is currently inside a comment such as // or /* ... */.        
        boolean withinComment = false;
//withString variable is for to keeping track of whether the code is currently inside a within double quotes.        
        boolean withinString = false;

//BufferedReader is to read the contents of the file/ Java source code.The try-with-resources construct is used to ensure that the BufferedReader is automatically closed when the block is exited
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //FileReader object is used to read characters from a file and File object named file as an argument for specified file to be read.
            String line;
//while loop is used to read each line of the Java source code file one by one.
            while ((line = reader.readLine()) != null) { //The loop continues until the end of the file is reached that is when reader.readLine() returns 'null'.
                // Use regular expressions to handle comments and strings
                
                //This line uses a regular expression to remove both line comments and block comments.
                String noCommentsLine = line.replaceAll("//.*|/\\*(.|\\n)*?\\*/", ""); //It replaces them with an empty string, removing comments from the current line, and stores the result in noCommentsLine.
                
                //Matcher object named stringMatcher is created to find double quoted strings within the noCommentsLine.
                Matcher stringMatcher = Pattern.compile("\"(\\\\\"|[^\"])*\"").matcher(noCommentsLine); // \"(\\\\\"|[^\"])*\" is used to match strings ing escaped double quotes or any characters except double quotes.

//The while loop: withinString variable based on the presence of strings within the line.
                while (stringMatcher.find()) {
                    withinString = !withinString; //The variable helps track whether the code is currently inside a string literal.
                }

//The if condition checks to see if the code is not within a string (like withinString is false) before proceeding.
                if (!withinString) {

//Matcher object named keywordMatcher is created to find Java keywords within the noCommentsLine.                    
                    Matcher keywordMatcher = Pattern.compile("\\b(\\w+)\\b").matcher(noCommentsLine); //\\b(\\w+)\\b is used to match whole words

//iterates over all the keyword matches in the line, and for each match, it checks if the keyword is in the keywordSet
                    while (keywordMatcher.find()) { //Within the loop, this line retrieves the matched keyword (a word) from the current match and stores it in the word variable.
                        String word = keywordMatcher.group(1); //The ''.group(1)'' method is used to retrieve the text matched by the first capturing group in the regular expression.
//The if statment checks whether the 'word' varible is present in the keywordSet.                        
                        if (keywordSet.contains(word)) {
                            count++; //If the 'word' variable is matched keyword and is found in the keywordSet, then 'count' variable increments. 
                        }
                    }
                }
            }
        } 
//This block catches any IOException that might occur during the file reading process.
        catch (IOException e) {
            e.printStackTrace();
        }
//The method then returns the total count of Java keywords found in the entire file.        
        return count;
    }
}
