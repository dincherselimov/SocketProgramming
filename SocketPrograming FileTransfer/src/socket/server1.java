package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(92);
        Socket socket1 = socket.accept();

        InputStreamReader in = new InputStreamReader(socket1.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();

        System.out.println("client " + str);

        PrintWriter out = new PrintWriter(socket1.getOutputStream(),true);
        out.println("yes");

    }
}
