package my_test.ch06;

import java.io.PrintWriter;
import java.util.Vector;

public class MultiNSever {

    private static final int PORT = 5000;
    private static final String UPLOAD_DIR = "Uploads/";

    private static Vector<PrintWriter> clientWriters = new Vector<>();
    private static int connectedCount = 0;



}
