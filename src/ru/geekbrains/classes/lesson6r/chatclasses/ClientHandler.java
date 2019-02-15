package ru.geekbrains.classes.lesson6r.chatclasses;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private final Socket socket;
    private Thread handleThread;
    private DataInputStream input;
    private DataOutputStream output;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            this.input = new DataInputStream(socket.getInputStream());
            this.output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String msg = input.readUTF();
                        System.out.println("Message: " + msg);
                        output.writeUTF(msg);
                        output.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        handleThread.start();
    }

    public void sendMessage(String message) {
        try {
            output.writeUTF(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
