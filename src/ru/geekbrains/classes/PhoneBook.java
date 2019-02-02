package ru.geekbrains.classes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private static Map<String, Contact> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        Contact contact;
        String key = name.toUpperCase();
        if (book.containsKey(key)) {
            contact = book.get(key);
        } else {
            contact = new Contact(key);
        }
        contact.addPnoneNumber(phoneNumber);
        book.put(key, contact);
    }

    /**
     * Выводит на дисплей все номера, которые соответствуют переданному имени
     * @param name имя
     */
    public List<String> get(String name) {
        String key = name.toUpperCase();
        if (!book.containsKey(key)){
            return Collections.EMPTY_LIST;
        }
        return book.get(key).getPhoneNumbers();
    }
}
