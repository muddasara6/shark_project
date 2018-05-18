package task1;

import java.io.*;
import java.util.*;
// Java Logging API 
import java.util.logging.*;

/**
 * Creates a subclass of the base class for OutputStream
 * Inherit from OutputStream interface to implement the adapter pattern
 */
public class TreeOutputStream extends OutputStream {

    /**
     * Prevents subclasses from overriding or hiding
     * ArrayList created for OutputStream
     */  
    private final List<OutputStream> streams;

    // Input and output Stream will be added to the list
    public void add(OutputStream os) {
        streams.add(os);
    }

    // Input and output Stream will be removed from the list
    public void remove(OutputStream os) {
        streams.remove(os);
    }

    // Constructor for OutputStream array
    public TreeOutputStream() {
        streams = new ArrayList<>();
    }

    @Override
    // Throw exception for method
    public void write(int i) throws IOException {
        // Stream will loop over all streams calling their write method
        streams.stream().forEach(strm-> {
            try {
                strm.write(i);
            } catch (IOException ex) {
                // It assumes the current class is called TreeOutputStream
                Logger.getLogger(TreeOutputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
