package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public Socket socket;  // это класс, который содержит сведения о клиенте
    private ObjectOutputStream output1;
    private ObjectInputStream input1;

    public Client(Socket socket, ObjectOutputStream output1, ObjectInputStream input1) {
        this.socket = socket;
        this.output1 = output1;
        this.input1 = input1;
    }

    public Socket getSocket() {
        return socket;
    }

    public ObjectOutputStream getOutput1() {
        return output1;
    }

    public void setOutput1(ObjectOutputStream output1) {
        this.output1 = output1;
    }

    public ObjectInputStream getInput1() {
        return input1;
    }

}
