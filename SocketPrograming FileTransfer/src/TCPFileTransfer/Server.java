package TCPFileTransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class is used for:
 * This class establishes a connection with Client.java class via tcp socket connection
 * This class reads the full length of a  file sent by the client
 * and saves the file to certain directory
 */
public class Server extends Thread {

    public static void main(String[] args) throws IOException {
        new Server().start();

        ClientHandler clientHandler = new ClientHandler();
        clientHandler.start();

        Server.AcceptFileFromClient();
    }

    public static void AcceptFileFromClient() throws IOException {

        System.out.println("Service started, waiting for connection");

        //Create ServerSocket object, bind port, start waiting for connection
        ServerSocket ss = new ServerSocket(81);

        //accept method, return socket object
        Socket server = ss.accept();

        //Get input object, read file
        BufferedInputStream bis = new BufferedInputStream(server.getInputStream());

        //Save to local
        //Specify path
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/TCPFileTransfer/ttt21.txt"));

        //Create byte array
        byte[] b = new byte[1024 * 8];
        //Read character array
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        //close resource
        bos.close();
        bis.close();
        server.close();
        System.out.println("Upload succeeded");
    }
}  