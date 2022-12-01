package app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ClientHandler {

    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 123;
    private static ObjectInputStream inputStream;
    private static ObjectOutputStream outputStream;
    private Thread readMessage;


    public ClientHandler() {
        try {
            try{
                this.clientSocket = new Socket("127.0.0.1", 123);
                inputStream =  new ObjectInputStream(clientSocket.getInputStream());
                outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                readMessage.start();

            } catch (IOException ex) {
                ex.printStackTrace();
            }


        } finally {
            System.out.println("Клиент закрыт");
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}







