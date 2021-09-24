package TCPFileTransfer;

import java.io.*;
import java.net.Socket;
import java.lang.*;

/**
 * This class is used for:
 * This class establishes a connection with Server.java class via tcp socket connection
 * This class sends a file with it's content to the server
 */
public class Client extends Thread {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

    }

    @Override
    public void run(){
        try {
            SendFileToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @throws IOException
     */
    public void SendFileToServer() throws IOException {
        //Create input stream
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/TCPFileTransfer/SSHKey.txt"));
        //Create Socket
        Socket client = new Socket("localhost", 81);
        //Output stream
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        //Write data
        byte[] b = new byte[1024 * 8];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
            bos.flush();
        }
        System.out.println("File uploaded");

        //close resource
        bos.close();
        client.close();
        bis.close();
        System.out.println("File upload completed");
    }
}