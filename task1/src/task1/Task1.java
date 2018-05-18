package task1;
// import refers to classes which are declared in other packages
import java.util.*;
import java.io.*;

public class Task1 {
    
    public static void main(String[] args) {
        
        // ArrayList to create arrays for each data in the text file Items can be added and removed from the list
        List<Shark> sharkFile = new ArrayList<>();
        
        // HashSet created for both even and odd words Used to find an unordered collection containing unique words in the Latin names
        Set<String> uniqueEvenWord = new HashSet<>();
        Set<String> uniqueOddWord = new HashSet<>();
        
        // Value set to null to increment the number of letters in the Latin names
        int numberOfLetters = 0;
        
        // Contains set of statements where an exception can occur
        try {
            // Reads the text in the shark-data file
            BufferedReader br = new BufferedReader(new FileReader("shark-data.txt"));
            // Reads each line in the file
            String fileRead = br.readLine();
            // Print representation of various data values conveniently
            PrintStream finalStream;
            TreeOutputStream tos;
            PrintStream out;
            // Save all the outputs to a text file in the NetBeans project root folder called results.txt
            out = new PrintStream("results.txt");
            tos = new TreeOutputStream();
            tos.add(out);
            tos.add(System.out);
            finalStream = new PrintStream(tos);
            // reassigns the "standard" output stream
            System.setOut(finalStream);
            // while loop containing block of statements while(Boolean_expression)
            while (fileRead != null) {
                // Returns an array of strings after splitting
                String[] sharkData = fileRead.split(":");
                // Creating a String of arrays
                String commonName = sharkData[0];
                String latinName = sharkData[1];
                // Parsing a String method argument into an Integer object
                int maxLengthInCentimetres = Integer.parseInt(sharkData[2]);
                int maxDepthInMetres = Integer.parseInt(sharkData[3]);
                String maxNumberInLifetime = sharkData[4];
                int globalPresenceIndicator = Integer.parseInt(sharkData[5]);
                String listOfOceanicRegions = sharkData[6];
                // Objects of states and behaviors in the Shark class
                Shark sharkObj = new Shark(commonName, latinName, maxLengthInCentimetres, maxDepthInMetres, maxNumberInLifetime, globalPresenceIndicator, listOfOceanicRegions);
                // Adding the Object to the ArrayList
                sharkFile.add(sharkObj);
                // Reading each line of text in the text file
                fileRead = br.readLine();
                // Latin name is the keyword used inside the method and calculates the number of letters in the Latin names
                numberOfLetters += countLetter(latinName);
            }
            // close method to clean up resources explicitly
            br.close();
        } // Thrown exception if a specified pathname does not exist 
        catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } // Thrown exception whenever an input or output operation is failed or interpreted
        catch (IOException ex) {
            System.out.println("An error has occured: " + ex.getMessage());
        }
        
        // foreach loop to read each element, which is equivalent to java.util.Iterator
        for (Shark getWords : sharkFile) {
            // Splitting the Latin names to remove the spaces in each word, so it does not count the spaces
            String[] evenWord = getWords.getLatinName().split("[^a-zA-Z]+");
            for (String evenData : evenWord) {
                /**
                 * if statement to find the number of words in the Latin names Every even number is divisible by two, and can find the number of even words in a String
                 */
                if (evenData.length() % 2 == 0) {
                    // Counting the even words for lowercase strings using the toLowerCase method
                    uniqueEvenWord.add(evenData.toLowerCase());
                }
            }
            String[] oddWord = getWords.getLatinName().split("[^a-zA-Z]+");
            for (String oddData : oddWord) {
                // Modulus operator to find the number of odd words in the Latin names
                if (oddData.length() % 2 == 1) {
                    uniqueOddWord.add(oddData.toLowerCase());
                }
            }
        }
        
        // Printing message to console
        System.out.println("--- Three largest sharks ---");
        
        // Sorts the maximum length present in a descending order by reversing it
        Collections.sort(sharkFile, Collections.reverseOrder(new Shark.maxLength()));
        sharkFile.stream().limit(3).forEach(System.out::println);
        System.out.println("\n--- Three smallest sharks ---");
        
        // Sorts the maximum length present in a ascending order
        Collections.sort(sharkFile, new Shark.maxLength());
        
        // Limit of 3 messages to print, so it will only print out the three largest sharks 
        sharkFile.stream().limit(3).forEach(System.out::println);
        System.out.println("\n------------------");
        System.out.print("Total number of letters in all Latin names = ");
        System.out.println(numberOfLetters);
        System.out.print("Total number of unique even words in Latin names"
                + " = ");
        
        // Finds the number of elements in the Latin name array
        System.out.println(uniqueEvenWord.size());
        System.out.print("Total number of unique odd words in Latin names"
                + " = ");
        System.out.println(uniqueOddWord.size());
    }
    
    // Static integer variable to find objects in the blueprint (Shark class)
    public static int countLetter(String sharkData) {
        // Increment count each time the program runs
        int count = 0;
        // If the file does exist, execute the following statements
        if (sharkData != null && !sharkData.isEmpty()) {
            String[] removeSpace = sharkData.split("[^a-zA-Z]+");
            for (String letters : removeSpace) {
                count += letters.length();
            }
        }
        // Any method not declared as void must contain a return statement, so the increment must be returned
        return count;
    }
}
