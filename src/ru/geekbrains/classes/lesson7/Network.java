package ru.geekbrains.classes.lesson7;

import ru.geekbrains.classes.lesson7.auth.AuthException;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Network implements Closeable {

    private static final String AUTH_PATTERN = "/auth %s %s";
    private static final String MESSAGE_SEND_PATTERN = "/w %s %s";
    private static final String USER_LIST_PATTERN = "/userlist";
    private static final Pattern MESSAGE_PATTERN = Pattern.compile("^/w (\\w+) (.+)", Pattern.MULTILINE);

    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private MessageSender messageSender;
    private Thread receiver;
    private String username;
    private final String hostName;
    private final int port;

    public Network(String hostName, int port, MessageSender messageSender) throws IOException {
        this.socket = new Socket(hostName, port);
        this.hostName = hostName;
        this.port = port;
//        this.output = new DataOutputStream(socket.getOutputStream());
//        this.input = new DataInputStream(socket.getInputStream());
        this.messageSender = messageSender;

        this.receiver = createReceiverThread();
    }

    private Thread createReceiverThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String text = input.readUTF();
                        System.out.println("New message " + text);
                        Matcher matcher = MESSAGE_PATTERN.matcher(text);
                        if (matcher.matches()) {
                            Message msg = new Message(matcher.group(1), username, matcher.group(2));
                            messageSender.submitMessage(msg);
                        } else if (text.startsWith(USER_LIST_PATTERN)) {
                            // TODO обновить список полключенных пользователей
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf("Network connection is closed for user %s%n", username);
            }
        });
    }

    public void sendMessageToUser(Message message) {
        sendMessage(String.format(MESSAGE_SEND_PATTERN, message.getUserTo(), message.getText()));
    }

    private void sendMessage(String msg) {
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
            socket.close();
            // Нужно подождать пока receiver прервется, затем
            receiver.interrupt();
            receiver.join();
        } catch (IOException e) {
            System.out.println("Клиентское соединение закрыто");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void authorize(String username, String password) {
        try {
            socket = new Socket(hostName, port);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());

            output.writeUTF(String.format(AUTH_PATTERN, username, password));
            String response = input.readUTF();
            if (response.equals("/auth sucsessful")) {
                this.username = username;
                receiver.start();
            } else {
                throw new AuthException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
