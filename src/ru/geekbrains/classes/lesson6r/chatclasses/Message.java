package ru.geekbrains.classes.lesson6r.chatclasses;

import java.time.LocalTime;

public class Message {
    private String userName;
    private String message;
    private LocalTime time;

    public Message(String userName, String message) {
        this.userName = userName;
        this.message = message;
        this.time = LocalTime.now();
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public LocalTime getTime() {
        return time;
    }
}
