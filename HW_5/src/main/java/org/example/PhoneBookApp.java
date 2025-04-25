package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneBookApp extends JFrame {
    private PhoneBook phoneBook;
    private JList<Contact> contactList;
    private JTextField nameField;
    private JTextField phoneField;

    public PhoneBookApp() {
        phoneBook = new PhoneBook();

        setTitle("Телефонный справочник");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание элементов интерфейса
        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        JButton addButton = new JButton("Добавить");
        JButton deleteButton = new JButton("Удалить");

        contactList = new JList<>(phoneBook.getContactListModel());
        JScrollPane scrollPane = new JScrollPane(contactList);

        // Настройка кнопки добавления
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                if (!name.isEmpty() && !phone.isEmpty()) {
                    phoneBook.addContact(new Contact(name, phone));
                    nameField.setText("");
                    phoneField.setText("");
                }
            }
        });

        // Настройка кнопки удаления
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact selectedContact = contactList.getSelectedValue();
                if (selectedContact != null) {
                    phoneBook.removeContact(selectedContact);
                }
            }
        });

        // Настройка компоновки
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel("Имя:"));
        panel.add(nameField);
        panel.add(new JLabel("Телефон:"));
        panel.add(phoneField);
        panel.add(addButton);
        panel.add(deleteButton);

        // Добавление компонентов в окно
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {SwingUtilities.invokeLater(() -> {
        PhoneBookApp app = new PhoneBookApp();
        app.setVisible(true);
    });
    }
}