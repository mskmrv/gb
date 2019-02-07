package ru.geekbrains.classes.lesson4;

import javax.swing.*;

public class App {
    private static ChatWiwdow chatWiwdow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatWiwdow = new ChatWiwdow();
            }
        });
    }
}
