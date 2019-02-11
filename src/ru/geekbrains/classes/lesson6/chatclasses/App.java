package ru.geekbrains.classes.lesson6.chatclasses;

import javax.swing.*;

public class App {
    private static ChatWindow chatWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatWindow = new ChatWindow();
            }
        });
    }
}
