package TCP.IO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1010); // server socket is created at port 1010
        Socket waiter = server.accept(); // socket like a seller waiting for a client to come

        InputStream userMessage = waiter.getInputStream(); // waiter gets the orders from client
        BufferedReader reader = new BufferedReader(new InputStreamReader(userMessage)); // delivers it to chef to cook

        String message = reader.readLine(); // wanted list
        System.out.println("Client says: "+message);

        waiter.close();
        server.close();

    }
}
