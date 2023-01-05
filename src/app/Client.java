package app;

import java.net.Socket;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    private String host;
    private int port;
    Socket socket;
    private Message message;
    private Scanner scanner;


    public Client(String host, int port) {
        this.host = host;
        this.port = port;

    }

    public void start(){
        System.out.println("Enter Your Name:");

        String name = scanner.nextLine();
        String text = scanner.nextLine();
        while (true) {
            System.out.println("Enter your message");

            sendAndPrintMessage(new Message(name, text));
            if ("/exit".equals(message)) break;
        }
    }

    private void  sendAndPrintMessage(Message message){
        try (Connection connection = new Connection(new Socket(host, port))){
            connection.sendMessage(message);
            Message fromServer = connection.readMessage();
            System.out.println("Ответ сервера:\n" + fromServer.getText());
        } catch (IOException e) {
            System.out.println("Send - receive error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Message Error");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}
