package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket clientSocket;
    private static ServerSocket serverSocket;
    private Message message;
    private ObjectInputStream inputStream;
    private ObjectInputStream outputStream;

    public void clientSocket(Socket clientSocket) {
        Message message = new Message("Иван", "Добрый день!", "15:50");
        try {
            clientSocket = new Socket("127.0.0.1", 123);
            ObjectInputStream inputStream = new ObjectInputStream(this.clientSocket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(this.clientSocket.getOutputStream());
            this.message = (Message) inputStream.readObject();
            this.outputStream = (Message) outputStream.writeObject(message);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Thread writeMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Message message = new Message("Иван", "Добрый день!", "15:50 25/11/22");
                    try {
                        outputStream.writeUTF(message);
                    } catch (IOException e) {

                    }

                }
            }
        });
    }

    Thread readMessage = new Thread(new Runnable() {
        @Override
        public void run() {

            while (true) {
                try {
                    String message = String.valueOf(inputStream.readObject());
                    System.out.println(message);
                } catch (IOException e) {

                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    });
}
