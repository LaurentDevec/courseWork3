package app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server extends Thread{
    ServerSocket serverSocket = null;
    Socket socket = null;
    ArrayList<Client> clients;
    Message message;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            this.start();
        } catch (IOException ioException) {
            System.out.println("ServerSocketError");
            ioException.printStackTrace();
        }
    }

    public void run(){

        while(true){
            try {
                socket = serverSocket.accept();
                Client client = new Client("127.0.0.1", 123);
                clients.add(client);
                client.start();
                System.out.println("Connected " + String.valueOf(clients.size()));
            }catch (Exception e){
                System.out.println("ClientConnectError");
                e.printStackTrace();
            }
        }
    }
}
