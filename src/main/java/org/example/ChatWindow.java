package org.example;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private int WINDOW_POS_X = 100;
    private int WINDOW_POS_Y = 300;
    private int WINDOW_WIDTH = 550;
    private int WINDOW_HEIGHT = 350;

    private String login;
    private String server;
    private Logging logging;
    private String msgText = "";
    private JButton sendButton = new JButton("Send");
    private JLabel inputLabel = new JLabel("Send message");
    private JTextField inputField = new JTextField();
    private JTextArea outputField = new JTextArea();
    private JPanel mainGrid = new JPanel(new GridLayout(1,2));
    private JPanel inputGrid = new JPanel(new GridLayout(3,1));

    ChatWindow(String login, String server, Logging logging) throws IOException{
        super("Sever: " + server);
        this.logging = logging;
        this.login = login;
        this.server = server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        initWindow();

        inputGrid.add(outputField);
        inputGrid.add(inputLabel);
        inputGrid.add(inputField);
        mainGrid.add(inputGrid);
        mainGrid.add(sendButton);
        add(mainGrid);
        setVisible(true);
    }

    private void initWindow() throws IOException{
        outputField.enableInputMethods(false);
        outputField.setBackground(Color.LIGHT_GRAY);


        StringBuilder builder = new StringBuilder();
        for (String string : logging.Read()) {
            builder.append(string);
            builder.append("\n");
        }
        outputField.setText(builder.toString());

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString();
                String msgText = dt + " " + login + ": " + inputField.getText();
                try {
                    logging.Write(msgText);
                    outputField.append(msgText);
                    outputField.append("\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                inputField.setText("");
            }
        });
        inputField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString();
                    String msgText = dt + " " + login + ": " + inputField.getText();
                    try {
                        logging.Write(msgText);
                        outputField.append(msgText);
                        outputField.append("\n");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    inputField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

    }
}
