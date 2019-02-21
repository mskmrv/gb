package ru.geekbrains.classes.lesson7;

import ru.geekbrains.classes.lesson7.auth.LoginDialog;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ChatWindow extends JFrame implements MessageSender {
    private JTextField textField;
    private JButton button;
    private JScrollPane scrollPane;
    private JList<Message> messageList;
    private DefaultListModel<Message> messageListModel;
    private JList<String> userList;
    private JPanel panel;

    private Network network;

    public ChatWindow() {
        super("Чат");
        initWindow();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        messageListModel = new DefaultListModel<>();
        messageList = new JList<>(messageListModel);
        messageList.setCellRenderer(new MessageCellRenderer());
        messageList.setBorder(new TitledBorder("Сообщения"));
        scrollPane = new JScrollPane(messageList);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(messageList, BorderLayout.SOUTH);
        panel.setBackground(messageList.getBackground());
        panel.add(scrollPane, BorderLayout.CENTER);

        userList = new JList<>();
        // TODO добавить класс Model для userList по аналогии с messageListModel
        userList.setListData(new String[]{"ivan", "petr", "julia"});
        userList.setPreferredSize(new Dimension(100, 0));
        add(userList, BorderLayout.WEST);

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String userTo = userList.getSelectedValue();
                    String text = textField.getText();
                    Message msg = new Message(network.getUsername(), userTo, text.trim());
                    submitMessage(msg);
                    textField.setText("");
                }
            }
        });

        button = new JButton("Отправить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userTo = userList.getSelectedValue();
                if (userTo == null) {
                    JOptionPane.showMessageDialog(ChatWindow.this,
                            "Не указан получатель",
                            "Отправка сообщения",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String text = textField.getText();
                if (text == null || text.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(ChatWindow.this,
                            "Нельзя отправить пустое вообщение",
                            "Отправка сообщения",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Message msg = new Message(network.getUsername(), userTo, text.trim());
                submitMessage(msg);
                textField.setText("");
                textField.requestFocus();
            }
        });
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String userTo = userList.getSelectedValue();
                    String text = textField.getText();
                    if (text == null || text.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(ChatWindow.this,
                                "Нельзя отправить пустое вообщение",
                                "Отправка сообщения",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Message msg = new Message(network.getUsername(), userTo, text.trim());
                    submitMessage(msg);
                    textField.setText("");
                    textField.requestFocus();
                    network.sendMessageToUser(msg);
                }
            }
        });

        Box row = Box.createHorizontalBox();
        row.add(Box.createHorizontalGlue());
        row.add(textField);
        row.add(Box.createHorizontalGlue());
        row.add(button);
        row.add(Box.createHorizontalGlue());

        panel.add(row);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (network != null) {
                    network.close();
                }
                super.windowClosing(e);
            }
        });

        setVisible(true);
        textField.requestFocus();

        try {
            network = new Network("localhost", 7777, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LoginDialog loginDialog = new LoginDialog(this, network);
        loginDialog.setVisible(true);

        if (!loginDialog.isConnected()) {
            System.exit(0);
        }
    }

    @Override
    public void submitMessage(Message msg) {
        messageListModel.add(messageListModel.size(), msg);
        messageList.ensureIndexIsVisible(messageListModel.size() - 1);
    }

    private void initWindow() {
        //        JFrame.setDefaultLookAndFeelDecorated(true);
        int height = (int) getDimension().getHeight();
        int width = (int) getDimension().getWidth();
//        setSize(width / 2, height / 2);
        setSize(350, 500);
        setLocation(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);
    }

    private Dimension getDimension() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = new Dimension(toolkit.getScreenSize());
        return dimension;
    }
}
