package task1;

// import for Comparable
import java.util.*;

// Java Comparable interface to order the objects of user-defined class
public class Shark implements Comparable<Shark> {
    
    // Blocks the direct access from outer objects
    private String commonName;
    private String latinName;
    private int maxLengthInCentimetres;
    private int maxDepthInMetres;
    private String maxNumberInLifetime;
    private int globalPresenceIndicator;
    private String listOfOceanicRegions;

    // A constructor called to create an instance of an object
    public Shark(String commonName, String latinName, int maximumLength, int maximumDepth, String femaleShark, int presenceIndicator, String oceanicRegions) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.maxLengthInCentimetres = maximumLength;
        this.maxDepthInMetres = maximumDepth;
        this.maxNumberInLifetime = femaleShark;
        this.globalPresenceIndicator = presenceIndicator;
        this.listOfOceanicRegions = oceanicRegions;
    }

    // Setter to set a new field
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public void setMaxLengthInCentimetres(int maxLengthInCentimetres) {
        this.maxLengthInCentimetres = maxLengthInCentimetres;
    }

    public void setMaxDepthInMetres(int maxDepthInMetres) {
        this.maxDepthInMetres = maxDepthInMetres;
    }

    public void setMaxNumberInLifetime(String maxNumberInLifetime) {
        this.maxNumberInLifetime = maxNumberInLifetime;
    }

    public void setGlobalPresenceIndicator(int globalPresenceIndicator) {
        this.globalPresenceIndicator = globalPresenceIndicator;
    }

    public void setListOfOceanicRegions(String listOfOceanicRegions) {
        this.listOfOceanicRegions = listOfOceanicRegions;
    }
    
    /** 
     * Access the String variable from outer objects
     * Getter to get the private field
     */
    public String getCommonName() {
        return commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getMaxLengthInCentimetres() {
        return maxLengthInCentimetres;
    }

    public int getMaxDepthInMetres() {
        return maxDepthInMetres;
    }

    public String getMaxNumberInLifetime() {
        return maxNumberInLifetime;
    }

    public int getGlobalPresenceIndicator() {
        return globalPresenceIndicator;
    }

    public String getListOfOceanicRegions() {
        return listOfOceanicRegions;
    }    
    
    /**
     * A method for comparing two strings
     * String is converted into a Unicode value for comparison
     */
    @Override
    public int compareTo(Shark s) {
        // Comparing the common names of each shark
        return getCommonName().compareTo(s.getCommonName());
    }

    // A nested class that can be accessed from outer classes
    static class maxLength implements Comparator<Shark> {
        @Override
        // Comparison for the maximum length
        public int compare(Shark s1, Shark s2) {
            int length1 = s1.getMaxLengthInCentimetres();
            int length2 = s2.getMaxLengthInCentimetres();

            if (length1 == length2) {
                return 0; // If both objects are equal, return 0
            } else if (length1 > length2) {
                return 1; // If first object is greater than the second object, return a positive value
            } else {
                return -1; // If first object is less than the second object, return a negative value
            }
        }
    }
    
    @Override
    /**
     * A string representation of an object
     * Method can be overriden to customise the String representation of the object
     */
    public String toString() {        
        return commonName + ", Length = " + maxLengthInCentimetres + " centimetres";
    }
}
