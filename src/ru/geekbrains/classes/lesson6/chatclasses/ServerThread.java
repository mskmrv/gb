package ru.geekbrains.classes.lesson6.chatclasses;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerThread extends Thread {
    private static List<ServerThread> threadList = Collections.synchronizedList(new ArrayList<>());
    private final Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        threadList.add(this);
        try {
            while (true) {
                String msg = dataInputStream.readUTF();
                System.out.println("Message: " + msg);
                sendBroadcast(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendBroadcast(String message){
        for (ServerThread serverThread : threadList) {
            try {
                DataOutputStream output = serverThread.dataOutputStream;
                output.writeUTF(message);
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
