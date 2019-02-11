package ru.geekbrains.classes.lesson6.chatclasses;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ChatWindow extends JFrame implements MessageSender{
    private final DefaultListModel<Message> listModel;
    private JList<Message> list;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JTextField textField;
    private JButton button;

    private Network network;

    public ChatWindow() {
        super("Чат");
        initWindow();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setCellRenderer(new MessageCellRenderer());
        list.setBorder(new TitledBorder("Сообщения"));
        scrollPane = new JScrollPane(list);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text = textField.getText();
                    submitMessage("user", text);
                    network.sendMessage(text);
                }
            }
        });

        button = new JButton("Отправить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                submitMessage("user", text);
                network.sendMessage(text);
            }
        });
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text = textField.getText();
                    submitMessage("user", text);
                    network.sendMessage(text);
                    textField.requestFocus();
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

        try {
            network = new Network("localhost",  7777, this);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        setVisible(true);
        textField.requestFocus();
    }

    @Override
    public void submitMessage(String user, String message) {
        if (message == null || message.isEmpty()) {
            return;
        }
        listModel.add(listModel.size(), new Message(user, message));
        list.ensureIndexIsVisible(listModel.size() - 1);
        textField.setText("");
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
