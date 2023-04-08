package org.example.repository;

import org.example.model.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> getAllContacts();
    Contact getContactByName(String name);
    void addContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(String name);
}
