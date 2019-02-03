package ru.geekbrains.classes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class ChatWiwdow extends JFrame {

    public ChatWiwdow() {
        super("Чат");
        initWindow();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setBorder(new TitledBorder("Сообщения"));
        JScrollPane scrollPane = new JScrollPane(text);

        JPanel panel = new JPanel();
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 25));
        textField.setFocusable(true);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passText(text, textField);
                }
            }
        });

        JButton button = new JButton("Отправить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passText(text, textField);
            }
        });
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passText(text, textField);
                }
            }
        });

        Box row = Box.createHorizontalBox();
        row.add(textField);
//        row.add(Box.createHorizontalGlue()); // Почему-то не работает
        row.add(Box.createHorizontalStrut(10));
        row.add(button);

        panel.add(row);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void passText(JTextArea text, JTextField textField) {
        StringBuilder sb = new StringBuilder(text.getText());
        sb.append(textField.getText()).append("\n");
        text.setText(sb.toString());
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
