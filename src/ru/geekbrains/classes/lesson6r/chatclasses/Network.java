package ru.geekbrains.classes.lesson6r.chatclasses;

import javax.swing.*;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Network implements Closeable {

    private final Socket socket;
    private final DataOutputStream output;
    private final DataInputStream input;
    private final MessageSender messageSender;
    private final Thread receiver;

    public Network(String hostName, int port, MessageSender messageSender) throws IOException {
        this.socket = new Socket(hostName, port);
        this.output = new DataOutputStream(socket.getOutputStream());
        this.input = new DataInputStream(socket.getInputStream());
        this.messageSender = messageSender;

        this.receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String msg = input.readUTF();
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("New message: " + msg);
                                messageSender.submitMessage("server", msg);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        receiver.start();
    }

    public void sendMessage(String msg) {
        try {
            output.writeUTF(msg);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            receiver.interrupt();
            // Нужно подождать пока receiver прервется, затем
            socket.close();
//            output.close();
        } catch (IOException e) {
            System.out.println("Клиентское соединение закрыто");
            e.printStackTrace();
        }
    }
}
