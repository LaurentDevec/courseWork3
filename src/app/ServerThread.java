package app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread {

    private final InputStreamReader inputStream;
    private final OutputStreamWriter outputStream;
    private Thread writeMessage;
    private Socket clientSocket;

    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет
    private Message message;
    private ServerSocket serverSocket;

    public ServerThread(Socket socket) throws IOException {
        this.clientSocket = socket;

        inputStream = new InputStreamReader(socket.getInputStream());
        outputStream = new OutputStreamWriter(socket.getOutputStream());
        writeMessage.start();
    }
    @Override
    public void run() {
        String word;
        try {

            while (true) {
                word = in.readLine();
                if(word.equals("stop")) {
                    break;                }
            }

        } catch (IOException e) {}
    }

    private void send(String message) {
        try {
            out.write(message + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }
}

