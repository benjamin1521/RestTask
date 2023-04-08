package org.example.controller;

import org.example.model.Contact;
import org.example.repository.ContactDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final ContactDao contactDao;

    public Controller(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @GetMapping("/contacts/{name}")
    public Contact getContactByName(@PathVariable String name) {
        return contactDao.getContactByName(name);
    }
}
