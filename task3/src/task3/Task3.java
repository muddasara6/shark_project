package task3;

import java.io.*;
import java.util.*;

public class Task3 {
    
    public static void main(String[] args) {
        
        String fileLocation = System.getProperty("user.dir");
        String dataPath = fileLocation + File.separator + "shark-data.txt";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataPath));
            String line;    
            ArrayList<Shark> sharks = new ArrayList<Shark>();
            ArrayList<String> Regions = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(":");
                String name = attributes[0];
                String latin = attributes[1];
                int length = Integer.parseInt(attributes[2]);
                int depth = Integer.parseInt(attributes[3]);
                int young = 0;
                if (!attributes[4].equals("UNKNOWN")) {
                    young = Integer.parseInt(attributes[4]);
                }
                int global = Integer.parseInt(attributes[5]);
                String[] regions = attributes[6].split(", ");
                for (int i = 0; i < regions.length; i++) {
                    if (regions[i].charAt(regions[i].length() - 1) == ' ') {
                        regions[i] = regions[i].replaceAll("\\s", "");         
                    }
                    if (!Regions.contains(regions[i])) {
                        Regions.add(regions[i]);
                    }
                }
                Shark shark = new Shark(name, latin, length, depth, young, global, regions);
                sharks.add(shark);
            }
            System.out.print("Enter search string for Latin names: > ");
            Scanner scanner = new Scanner(System.in);
            String match=scanner.next();
            match=match.toLowerCase();
            System.out.println("");
            System.out.println("You entered string \""+match+"\"");
            System.out.println("The following matches have been found :-"); 
            for(int i=0;i<sharks.size();i++){
                String latin=sharks.get(i).getLatin_Name();
                String temp=latin;
                latin=latin.toLowerCase();
                String Cap=match.toUpperCase();
                if(latin.contains(match)){
                    latin=latin.replaceAll(match, Cap);
                    if(temp.charAt(0)>=65 && temp.charAt(0)<=90){
                        latin=temp.charAt(0)+latin.substring(1);
                    }
                    System.out.println(sharks.get(i).getCommon_Name()+" : "+latin);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", dataPath);
            e.printStackTrace();
        }
    }
}
    