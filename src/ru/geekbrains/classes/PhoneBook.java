package ru.geekbrains.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private static Map<String, List<String>> book = new HashMap<>();

    static void add(String name, String phoneNumber) {
        List<String> numbers;
        name = name.trim().toLowerCase();
        if (book.containsKey(name)) {
            numbers = book.get(name);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(phoneNumber);
        book.put(name.trim().toLowerCase(), numbers);
    }

    /**
     * Этого не было в задании. Метод написан для тестирования.
     * Метод выводит на дисплей всю телефонную книгу.
     */
    static void print() {
        for (Map.Entry<String, List<String>> entry : book.entrySet()) {
            String name = entry.getKey();

            name = getModifiedName(name); // меняем первую букву на прописную

            List<String> values = entry.getValue();
            System.out.println("Имя: " + name + " " + values);
        }
    }

    /**
     * Выводит на дисплей все номера, которые соответствуют переданному имени
     * @param name имя
     */
    static void get(String name) {
        if (book.containsKey(name.trim().toLowerCase())) {
            List<String> numbers = book.get(name.trim().toLowerCase());
            name = getModifiedName(name); // меняем первую букву на прописную
            System.out.println("Имя: " + name + " , номера телефонов: " + numbers);
        }
    }

    /**
     * т.к. имена в Map book хранятся строчными буквами, при выводе меняем первую букву на прописную
     * @param name передаваемое имя начинается с маленькой буквы
     * @return Возвращает имя начинающееся с большой буквы
     */
    private static String getModifiedName(String name) {
        StringBuilder sb = new StringBuilder(name);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        name = sb.toString();
        return name;
    }
}
