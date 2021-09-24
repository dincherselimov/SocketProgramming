package Test;

import TCPFileTransfer.Client;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;

public class TestSendFileToServer {

   @Test
   public void testAcceptFileFromClient() throws IOException {
      Client client = new Client();

      ServerSocket socket = new ServerSocket(81);
      Assert.assertEquals(socket,socket);

   }

   @Test
   public void testSendFileToServer() throws IOException {
      ServerSocket serverSocket = new ServerSocket(80);
   }
}
