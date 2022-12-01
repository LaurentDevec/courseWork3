package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server1 {
    static ExecutorService executeIt = Executors.newFixedThreadPool(2);
    private static int PORT;
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static Client client;
    private static Message message;
    private static ObjectInputStream inputStream;
    private static ObjectOutputStream outputStream;

    public static void main(String[] args) {
        try {
            try {
                serverSocket = new ServerSocket(123);
                System.out.println("Сервер запущен!");
                while (true) {
                    clientSocket = serverSocket.accept();
                    ClientHandler client = new ClientHandler();
                    new Thread((Runnable) client).start();
                    try {
                        ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                        ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                        System.out.println(message);
                        outputStream.write(Integer.parseInt("Направлено сообещние: " + message + "\n"));
                        outputStream.flush();
                    } finally {
                        clientSocket.close();
                        inputStream.close();
                        outputStream.close();
                        System.out.println("Сервер закрыт!");
                        serverSocket.close();
                    }
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
