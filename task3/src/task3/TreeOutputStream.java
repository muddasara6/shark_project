package task3;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeOutputStream extends OutputStream {

    private final List<OutputStream> streams;

    public void add(OutputStream os) {
        streams.add(os);
    }

    public void remove(OutputStream os) {
        streams.remove(os);
    }

    public TreeOutputStream() {
        streams = new ArrayList<>();
    }

    @Override
    public void write(int i) throws IOException {
        streams.stream().forEach(strm-> {
            try {
                strm.write(i);
            } catch (IOException ex) {
                Logger.getLogger(TreeOutputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
