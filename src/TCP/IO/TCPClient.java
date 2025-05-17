package TCP.IO;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket connection = new Socket("localhost", 1010); // clients uses the connection to order

        OutputStream write = connection.getOutputStream();
        DataOutputStream text = new DataOutputStream(write);

        byte[] bytes = "Salam".getBytes(); //message and its length for sending
        int length = bytes.length;

        text.writeInt(length); // sending length of message then message itself
        text.write(bytes);

        connection.close();
    }
}
