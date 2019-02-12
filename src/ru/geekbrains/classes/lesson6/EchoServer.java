package ru.geekbrains.classes.lesson6;

import ru.geekbrains.classes.lesson6.chatclasses.ServerThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                ServerThread thread = new ServerThread(socket);
                thread.start();
            }

            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
