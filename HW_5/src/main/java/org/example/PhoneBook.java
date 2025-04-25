package org.example;

import javax.swing.DefaultListModel;

public class PhoneBook {
    private DefaultListModel<Contact> contactListModel;

    public PhoneBook() {
        contactListModel = new DefaultListModel<>();
    }

    public void addContact(Contact contact) {
        contactListModel.addElement(contact);
    }

    public void removeContact(Contact contact) {
        contactListModel.removeElement(contact);
    }

    public DefaultListModel<Contact> getContactListModel() {
        return contactListModel;
    }
}
