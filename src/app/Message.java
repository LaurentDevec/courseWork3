package app;

public class Message { // класс, содержадщий данные об отправяемом сообщении
    private static String name;  // имя отправителя сообщения
    private static String text;  // текст сообщения
    private static String time;  // дата


    public Message(String name, String message, String time) {
        this.name = name;
        this.text = message;
        this.time = time;
    }

    public static String getName() {
        return name;
    }

    public static String getText() {
        return text;
    }

    public static String getTime() { return time; }

    @Override
    public String toString() {
        return "Message{" +
                "username' " + name + '\'' +
                "text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
