package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConnectWindow extends JFrame {

    private int WINDOW_HEIGHT = 400;
    private int WINDOW_WIDTH = 550;
    private int WINDOW_POS_X = 300;
    private int WINDOW_POS_Y = 100;
    private Logging logging;

    JLabel loginLabel = new JLabel("Login");
    JTextArea loginField = new JTextArea(1, 20);


    JLabel passwordLabel = new JLabel("Password");
    JTextArea passwordField = new JTextArea(1, 20);

    JLabel serverLabel = new JLabel("Address");
    JTextArea serverField = new JTextArea(1, 20);

    JButton buttonConnect = new JButton();

    JPanel grid = new JPanel(new GridBagLayout());

    GridBagConstraints c1 = new GridBagConstraints();
    GridBagConstraints c2 = new GridBagConstraints();
    GridBagConstraints c3 = new GridBagConstraints();
    GridBagConstraints c4 = new GridBagConstraints();
    GridBagConstraints c5 = new GridBagConstraints();
    GridBagConstraints c6 = new GridBagConstraints();
    GridBagConstraints c7 = new GridBagConstraints();



    ConnectWindow(Logging logging){
        super("Chat");
        this.logging = logging;
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        serverLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        buttonConnect.setText("Connect");
        buttonConnect.setFont(new Font("Dialog", Font.BOLD, 14));
        buttonConnect.setBackground(new Color(144, 238, 144));

        c1.weightx = 0;
        c1.weighty = 0;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridheight = 1;
        c1.gridwidth = 1;

        c2.weightx = 0;
        c2.weighty = 0;
        c2.gridx = 0;
        c2.gridy = 1;
        c2.gridheight = 1;
        c2.gridwidth = 1;

        c3.weightx = 0;
        c3.weighty = 0;
        c3.gridx = 1;
        c3.gridy = 0;
        c3.gridheight = 1;
        c3.gridwidth = 1;

        c4.weightx = 0;
        c4.weighty = 0;
        c4.gridx = 1;
        c4.gridy = 1;
        c4.gridheight = 1;
        c4.gridwidth = 1;

        c5.weightx = 0;
        c5.weighty = 0;
        c5.gridx = 0;
        c5.gridy = 2;
        c5.gridheight = 1;
        c5.gridwidth = 1;

        c6.weightx = 0;
        c6.weighty = 0;
        c6.gridx = 1;
        c6.gridy = 2;
        c6.gridheight = 1;
        c6.gridwidth = 1;

        c7.weightx = 0;
        c7.weighty = 0;
        c7.gridx = 1;
        c7.gridy = 3;
        c7.gridheight = 1;
        c7.gridwidth = 1;

        setResizable(false);
        setBackground(new Color(233, 233, 233));
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        grid.add(loginLabel, c1);
        grid.add(passwordLabel, c2);
        grid.add(loginField, c3);
        grid.add(passwordField, c4);
        grid.add(serverLabel, c5);
        grid.add(serverField, c6);
        grid.add(buttonConnect, c7);

        grid.revalidate();


        add(grid);


        initWindow();


        setVisible(true);
    }

    private void initWindow(){
        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String login = loginField.getText();
                String server = serverField.getText();
                try {
                    new ChatWindow(login, server, logging);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                setVisible(false);
            }
        });

    }
}