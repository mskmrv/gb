package ru.geekbrains.classes.lesson6.chatclasses;

import javax.swing.*;
import java.awt.*;

public class MessageCellRenderer extends JPanel implements ListCellRenderer<Message> {

    private JLabel userName;
    private JLabel message;

    public MessageCellRenderer() {
        super();
        setLayout(new BorderLayout());
        userName = new JLabel();
        Font font = userName.getFont();
        userName.setFont(font.deriveFont(Font.BOLD));
        message = new JLabel();
        add(userName, BorderLayout.NORTH);
        add(message, BorderLayout.SOUTH);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Message> list, Message value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {

        setBackground(list.getBackground());
        userName.setOpaque(true);
        userName.setText(value.getUserName());
        message.setText(value.getMessage());
        return this;
    }
}
