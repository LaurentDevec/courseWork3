import app.Client;
import app.Server;

public class Main {
    public static void main(String[] args) {
        new Server(123).start();
        new Client("127.0.0.1", 123).start();
    }
}