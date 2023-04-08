package org.example.repository;

import org.example.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {
    private List<Contact> contacts;
    private CarDao carDao;

    public ContactDaoImpl(CarDao carDao) {
        this.carDao = carDao;
        initContacts(carDao);
    }

    private void initContacts(CarDao carDao) {
        Contact petrov = new Contact(
                "Petrov",
                Arrays.asList(carDao.getCarByModel("Volvo"), carDao.getCarByModel("Audi"))
        );
        Contact sidorov = new Contact(
                "Sidorov",
                Collections.singletonList(carDao.getCarByModel("Toyota"))
        );
        Contact ivanov = new Contact(
                "Ivanov",
                Arrays.asList(carDao.getCarByModel("Honda"), carDao.getCarByModel("Toyota"))
        );
        contacts = List.of(petrov, sidorov, ivanov);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public Contact getContactByName(String name) {
        return contacts.stream()
                .filter(contact -> contact.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        deleteContact(contact.getName());
        contacts.add(contact);
    }

    @Override
    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }
}
