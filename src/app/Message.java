package app;

import java.time.LocalDateTime;

public class Message { // класс, содержадщий данные об отправяемом сообщении
    private static String name;  // имя отправителя сообщения
    private static String text;  // текст сообщения
    private LocalDateTime dateTime;  // дата


    public Message(String name, String message) {
        this.name = name;
        this.text = message;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setDateTime() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    @Override
    public String toString() {
        return "Message{" +
                "username' " + name + '\'' +
                "text='" + text + '\'' +
                ", time=" + dateTime +
                '}';
    }
}

