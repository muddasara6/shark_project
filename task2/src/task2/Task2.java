package task2;

import java.util.*;
import java.io.*;

public class Task2 {

    public static void main(String[] args) {
        
        List<Shark> sharkFile = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("shark-data.txt"));
            String fileRead = br.readLine();
            PrintStream finalStream;
            TreeOutputStream tos;
            PrintStream out;
            out = new PrintStream("results.txt");
            tos = new TreeOutputStream();
            tos.add(out);
            tos.add(System.out);
            finalStream = new PrintStream(tos);
            System.setOut(finalStream);
            while (fileRead != null) {
                String[] sharkData = fileRead.split(":");
                String commonName = sharkData[0];
                String latinName = sharkData[1];
                int maxLengthInCentimetres = Integer.parseInt(sharkData[2]);
                int maxDepthInMetres = Integer.parseInt(sharkData[3]);
                String maxNumberInLifetime = sharkData[4];
                int globalPresenceIndicator = Integer.parseInt(sharkData[5]);
                String listOfOceanicRegions = sharkData[6];
                Shark sharkObj = new Shark(commonName, latinName, maxLengthInCentimetres, maxDepthInMetres, maxNumberInLifetime, globalPresenceIndicator, listOfOceanicRegions);
                sharkFile.add(sharkObj);
                fileRead = br.readLine();
            }
            br.close();
        }         
        catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }         
        catch (IOException ex) {
            System.out.println("An error has occured: " + ex.getMessage());
        }

        // Objects in TreesSet class are stored in ascending order and removes duplicates automatically 
        Set<String> strSet = new TreeSet<>();
        // Locate the size in the arrays
        for (int i = 0; i < sharkFile.size(); i++) {
            String[] regionSplit = sharkFile.get(i).getListOfOceanicRegions().split(", ");
            for (int j = 0; j < regionSplit.length; j++) {
                strSet.add(regionSplit[j]);
            }
        }

        // Sort the common names for alphabetical ordering
        Collections.sort(sharkFile, new Shark.orderCommonName());
        // For-each loop containing the TreeSet and to read each element in the oceanic regions
        for (String p: strSet) {
            // Print element with an arrow and an opening square bracket beside it 
            System.out.printf("%s -> [", p);
            // Boolean value set to false
            boolean needComma = false;
            // Use indices instead of a for-each to check if there's a next element
            for (int i = 0; i < sharkFile.size(); ++i) {
                Shark s = sharkFile.get(i);
                if (s.getListOfOceanicRegions().contains(p)) {
                    // Only print out the comma and space if there's a preceding element
                    if (needComma) {
                        System.out.print(", ");
                    }
                    System.out.printf("%s", s.getCommonName());
                    needComma = true;
                }
            }
            // Print out the element with a closed square bracket at the end
            System.out.println("]");
        }
    }
}
