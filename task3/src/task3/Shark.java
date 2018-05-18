package task3;

public class Shark implements Comparable<Object> {
    
    private String Common_Name;
    private String Latin_Name;
    private int Max_Length;
    private int Max_Depth;
    private int Max_Young;
    private int Global_Presence_Indicator;
    private String[] Oceanic_Regions;   
    
    public Shark() {
        this.Common_Name = "";
        this.Latin_Name = "";
        this.Max_Length = 0;
        this.Max_Depth = 0;
        this.Max_Young = 0;
        this.Global_Presence_Indicator = 0;
        this.Oceanic_Regions = null;        
    }

    public Shark(String C_Name, String L_Name, int L, int D, int Y, int GPI, String[] OR) {
        this.Common_Name = C_Name;
        this.Latin_Name = L_Name;
        this.Max_Length = L;
        this.Max_Depth = D;
        this.Max_Young = Y;
        this.Global_Presence_Indicator = GPI;
        this.Oceanic_Regions = OR;        
    }

    public String getCommon_Name() {
        return Common_Name;
    }

    public void setCommon_Name(String Common_Name) {
        this.Common_Name = Common_Name;
    }

    public String getLatin_Name() {
        return Latin_Name;
    }

    public void setLatin_Name(String Latin_Name) {
        this.Latin_Name = Latin_Name;
    }

    public int getMax_Length() {
        return Max_Length;
    }

    public void setMax_Length(int Max_Length) {
        this.Max_Length = Max_Length;
    }

    public int getMax_Depth() {
        return Max_Depth;
    }

    public void setMax_Depth(int Max_Depth) {
        this.Max_Depth = Max_Depth;
    }

    public int getMax_Young() {
        return Max_Young;
    }

    public void setMaxYoung(int Max_Young) {
        this.Max_Young = Max_Young;
    }

    public int getGlobal_Presence_Indicator() {
        return Global_Presence_Indicator;
    }

    public void setGlobalPresenceIndicator(int Global_Presence_Indicator) {
        this.Global_Presence_Indicator = Global_Presence_Indicator;
    }

    public String[] getOceanic_Regions() {
        return Oceanic_Regions;
    }

    public void setOceanic_Regions(String[] Oceanic_Regions) {
        this.Oceanic_Regions = Oceanic_Regions;
    }

    @Override
    public int compareTo(Object o) {
        int compare_length = ((Shark)o).getMax_Length();
        return this.Max_Length - compare_length;
    }    
    
    @Override
    public String toString() {
        return ("Name : " + this.Common_Name + "\nLatin Name: " + this.Latin_Name + "\nLength : " + this.Max_Length +
                "\nDepth : " + this.Max_Depth + "\nYoung : " + this.Max_Young + "\n");
    }
}
