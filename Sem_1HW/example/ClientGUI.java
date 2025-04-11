package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String LOG_FILE_PATH = "C:\\Users\\ichir\\OneDrive\\Рабочий стол\\JAVA_Develoment_Kit\\chat_history.txt";

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8080");
    private final JTextField tfLogin = new JTextField("ichi005");
    private final JPasswordField tfPassword = new JPasswordField("12345");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel pannelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private JButton btnSend = new JButton("Send");

    ClientGUI(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH,HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        pannelBottom.add(tfMessage, BorderLayout.CENTER);
        pannelBottom.add(btnSend, BorderLayout.EAST);
        add(pannelBottom, BorderLayout.SOUTH);

        log.setEnabled(false);
        JScrollPane scrolLog = new JScrollPane(log);
        add(scrolLog);

        loadChatHistory();

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    private void loadChatHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line + "\n");
            }
        } catch (IOException e) {
            log.append("Error loading chat history: " + e.getMessage() + "\n");
        }
    }

    private void sendMessage() {
        String message = tfMessage.getText();
        if (!message.trim().isEmpty()) {
            log.append("You: " + message + "\n");
            tfMessage.setText("");

            try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
                writer.println("You: " + message);
            } catch (IOException e) {
                log.append("Error writing to log file: " + e.getMessage() + "\n");
            }
        }
    }




}
