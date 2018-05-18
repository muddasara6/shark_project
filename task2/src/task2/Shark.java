package task2;

import java.util.*;

public class Shark implements Comparable<Shark> {
    
    private String commonName;
    private String latinName;
    private int maxLengthInCentimetres;
    private int maxDepthInMetres;
    private String maxNumberInLifetime;
    private int globalPresenceIndicator;
    private String listOfOceanicRegions;    

    public Shark(String commonName, String latinName, int maxLengthInCentimetres, int maxDepthInMetres, String maxNumberInLifetime, int globalPresenceIndicator, String listOfOceanicRegions) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.maxLengthInCentimetres = maxLengthInCentimetres;
        this.maxDepthInMetres = maxDepthInMetres;
        this.maxNumberInLifetime = maxNumberInLifetime;
        this.globalPresenceIndicator = globalPresenceIndicator;
        this.listOfOceanicRegions = listOfOceanicRegions;
    }

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
    
    // Compare for alphabetical ordering in common names    
    @Override
    public int compareTo(Shark o) {
        return getCommonName().compareTo(o.getCommonName());
    }
    
    static class orderCommonName implements Comparator<Shark> {
        @Override
        public int compare(Shark s1, Shark s2) {                
            return s1.commonName.compareTo(s2.commonName);  
        } 
    }
}
