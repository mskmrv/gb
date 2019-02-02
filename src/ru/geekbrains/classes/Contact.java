package ru.geekbrains.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contact {
    private String name;
    private List<String> phoneNumbers;

    public Contact(String name) {
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPnoneNumber(String number){
        phoneNumbers.add(number);
    }

    public List<String> getPhoneNumbers() {
        // Вернем копию неизменяемого списка phoneNumbers
        return Collections.unmodifiableList(phoneNumbers);
    }
}
